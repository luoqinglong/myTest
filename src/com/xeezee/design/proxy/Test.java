/**
 * TODO
 */
package com.xeezee.design.proxy;

/**
 * 代理模式
 * 
 * @author luoqinglong
 * @date 2014-4-10
 */
public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Subject subject = new ProxySubject();
		subject.request();

	}

}
