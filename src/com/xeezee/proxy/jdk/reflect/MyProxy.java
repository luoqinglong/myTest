/**
 * TODO
 */
package com.xeezee.proxy.jdk.reflect;

import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import sun.misc.ProxyGenerator;

/**
 * @author luoqinglong
 * @date 2013-9-29
 */
public class MyProxy implements Serializable
{
	private final static String proxyClassNamePrefix = "$MyProxy";

	private final static Class[] constructorParams = { InvocationHandler.class };

	private static Map loaderToCache = new WeakHashMap();

	private static Object pendingGenerationMarker = new Object();

	private static long nextUniqueNumber = 0;
	private static Object nextUniqueNumberLock = new Object();

	private static Map proxyClasses = Collections.synchronizedMap(new WeakHashMap());

	protected InvocationHandler h;

	public MyProxy()
	{
	}

	public MyProxy(InvocationHandler h)
	{
		this.h = h;
	}

	public static Class<?> getProxyClass(ClassLoader loader, Class<?>... interfaces) throws IllegalArgumentException
	{
		if (interfaces.length > 65535)
		{
			throw new IllegalArgumentException("interface limit exceeded");
		}

		Class proxyClass = null;

		/* collect interface names to use as key for proxy class cache */
		String[] interfaceNames = new String[interfaces.length];

		Set interfaceSet = new HashSet(); // for detecting duplicates

		for (int i = 0; i < interfaces.length; i++)
		{

			String interfaceName = interfaces[i].getName();
			Class interfaceClass = null;
			try
			{
				interfaceClass = Class.forName(interfaceName, false, loader);
			}
			catch (ClassNotFoundException e)
			{
			}
			if (interfaceClass != interfaces[i])
			{
				throw new IllegalArgumentException(interfaces[i] + " is not visible from class loader");
			}

			if (!interfaceClass.isInterface())
			{
				throw new IllegalArgumentException(interfaceClass.getName() + " is not an interface");
			}

			if (interfaceSet.contains(interfaceClass))
			{
				throw new IllegalArgumentException("repeated interface: " + interfaceClass.getName());
			}
			interfaceSet.add(interfaceClass);

			interfaceNames[i] = interfaceName;
		}

		Object key = Arrays.asList(interfaceNames);

		/*
		 * Find or create the proxy class cache for the class loader.
		 */
		Map cache;
		synchronized (MyProxy.loaderToCache)
		{
			cache = (Map) MyProxy.loaderToCache.get(loader);
			if (cache == null)
			{
				cache = new HashMap();
				MyProxy.loaderToCache.put(loader, cache);
			}

		}

		synchronized (cache)
		{

			do
			{
				Object value = cache.get(key);
				if (value instanceof Reference)
				{
					proxyClass = (Class) ((Reference) value).get();
				}
				if (proxyClass != null)
				{
					return proxyClass;
				}
				else if (value == MyProxy.pendingGenerationMarker)
				{
					try
					{
						cache.wait();
					}
					catch (InterruptedException e)
					{

					}
					continue;
				}
				else
				{
					cache.put(key, MyProxy.pendingGenerationMarker);
					break;
				}
			}
			while (true);
		}

		try
		{
			String proxyPkg = null;

			for (int i = 0; i < interfaces.length; i++)
			{
				int flags = interfaces[i].getModifiers();
				if (!Modifier.isPublic(flags))
				{
					String name = interfaces[i].getName();
					int n = name.lastIndexOf('.');
					String pkg = ((n == -1) ? "" : name.substring(0, n + 1));
					if (proxyPkg == null)
					{
						proxyPkg = pkg;
					}
					else if (!pkg.equals(proxyPkg))
					{
						throw new IllegalArgumentException("non-public interfaces from different packages");
					}
				}
			}

			if (proxyPkg == null)
			{
				proxyPkg = "";
			}

			{

				long num;
				synchronized (MyProxy.nextUniqueNumberLock)
				{
					num = MyProxy.nextUniqueNumber++;
				}
				String proxyName = proxyPkg + MyProxy.proxyClassNamePrefix + num;

				byte[] proxyClassFile = ProxyGenerator.generateProxyClass(proxyName, interfaces);
				try
				{
					proxyClass = MyProxy.defineClass0(loader, proxyName, proxyClassFile, 0, proxyClassFile.length);
				}
				catch (ClassFormatError e)
				{

					throw new IllegalArgumentException(e.toString());
				}
			}
			MyProxy.proxyClasses.put(proxyClass, null);

		}
		finally
		{

			synchronized (cache)
			{
				if (proxyClass != null)
				{
					cache.put(key, new WeakReference(proxyClass));
				}
				else
				{
					cache.remove(key);
				}
				cache.notifyAll();
			}
		}
		return proxyClass;
	}

	public static boolean isProxyClass(Class<?> cl)
	{
		if (cl == null)
		{
			throw new NullPointerException();
		}

		return MyProxy.proxyClasses.containsKey(cl);
	}

	public static InvocationHandler getInvocationHandler(Object proxy) throws IllegalArgumentException
	{
		/*
		 * Verify that the object is actually a proxy instance.
		 */
		if (!MyProxy.isProxyClass(proxy.getClass()))
		{
			throw new IllegalArgumentException("not a proxy instance");
		}

		MyProxy p = (MyProxy) proxy;
		return p.h;
	}

	public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
			throws IllegalArgumentException
	{
		if (h == null)
		{
			throw new NullPointerException();
		}
		Class cl = MyProxy.getProxyClass(loader, interfaces);

		try
		{
			Constructor cons = cl.getConstructor(MyProxy.constructorParams);
			return cons.newInstance(new Object[] { h });
		}
		catch (NoSuchMethodException e)
		{
			throw new InternalError(e.toString());
		}
		catch (IllegalAccessException e)
		{
			throw new InternalError(e.toString());
		}
		catch (InstantiationException e)
		{
			throw new InternalError(e.toString());
		}
		catch (InvocationTargetException e)
		{
			throw new InternalError(e.toString());
		}
	}

	private static native Class defineClass0(ClassLoader loader, String name, byte[] b, int off, int len);
}
