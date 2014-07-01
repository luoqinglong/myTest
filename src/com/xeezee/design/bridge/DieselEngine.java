/**
 * TODO
 */
package com.xeezee.design.bridge;

/**
 * @author luoqinglong
 * @date 2014-4-8
 */
public class DieselEngine implements Engin
{

	/*
	 * (non-Javadoc)
	 * @see com.xeezee.design.bridge.Engin#start()
	 */
	@Override
	public void start()
	{
		System.out.println("DieselEngine.start()");

	}

	/*
	 * (non-Javadoc)
	 * @see com.xeezee.design.bridge.Engin#stop()
	 */
	@Override
	public void stop()
	{
		System.out.println("DieselEngine.stop()");

	}

}
