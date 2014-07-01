/**
 * TODO
 */
package com.xeezee.design.adapter;

/**
 * @author luoqinglong
 * @date 2014-4-2
 */
public class Adapter implements Target
{
	private final Adaptee eeAdaptee;

	public Adapter(Adaptee eeAdaptee)
	{
		this.eeAdaptee = eeAdaptee;
	}

	/*
	 * (non-Javadoc)
	 * @see com.xeezee.design.adapter.Target#methodA()
	 */
	@Override
	public void methodA()
	{
		this.eeAdaptee.methodB();

	}

}
