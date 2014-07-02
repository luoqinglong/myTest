/**
 * TODO
 */
package com.xeezee.design.proxy;

/**
 * 代理主题
 * 
 * @author luoqinglong
 * @date 2014-4-10
 */
public class ProxySubject implements Subject
{
	Subject subject;

	/*
	 * (non-Javadoc)
	 * @see com.xeezee.design.proxy.Subject#request()
	 */
	@Override
	public void request()
	{
		if (this.subject == null)
		{
			this.subject = new RealSubject();
		}
		this.preRequest();
		this.subject.request();
		this.doRequest();
	}

	public void preRequest()
	{
		System.out.println("preRequest代理前处理");
	}

	public void doRequest()
	{
		System.out.println("preRequest代理后处理");
	}
}
