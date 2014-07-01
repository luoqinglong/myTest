/**
 * TODO
 */
package com.xeezee.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author luoqinglong
 * @date 2013-9-28
 */
public class DBQueryFactory
{
	/**
	 * 创建IDBQuery接口的代理实例
	 * 
	 * @param target
	 * @return
	 */

	public static IDBQuery createJdkProxy(Object target)
	{
		IDBQuery jdkProxy = (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), target.getClass()
				.getInterfaces(), new JdkDBQueryHandler(target));
		return jdkProxy;
	}

	public static void main(String[] arg)
	{

		IDBQuery query = DBQueryFactory.createJdkProxy(new DBQueryImpl());
		Object r = query.request();
		System.out.println("main:" + r);
		char X[] = ("\000\020\040\060\100\120\140\160\200\220\240\260\300\320\340\360\200\u0100").toCharArray();
		for (int i = 0; i < X.length; i++)
		{

		}

	}
}
