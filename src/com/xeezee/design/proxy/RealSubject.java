/**
 * TODO
 */
package com.xeezee.design.proxy;

/**
 * 真实主题
 * 
 * @author luoqinglong
 * @date 2014-4-10
 */
public class RealSubject implements Subject
{

	/*
	 * (non-Javadoc)
	 * @see com.xeezee.design.proxy.Subject#request()
	 */
	@Override
	public void request()
	{
		System.out.println("RealSubject.request()真实主题");

	}

}
