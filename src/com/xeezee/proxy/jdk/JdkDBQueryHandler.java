/**
 * TODO
 */
package com.xeezee.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类(拦截器)
 * 
 * @author luoqinglong
 * @date 2013-9-28
 */
public class JdkDBQueryHandler implements InvocationHandler
{
	/**
	 * 被代理的类(主题类)
	 */
	Object target;

	public JdkDBQueryHandler(Object target)
	{
		this.target = target;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		System.out.println("method[invoke] in " + JdkDBQueryHandler.class);
		// 在代理的方法执行前，执行其他操作

		// 执行主题类的业务方法
		Object resultObject = method.invoke(this.target, args);

		// 代理的方法执行完成后

		return resultObject;
	}
}
