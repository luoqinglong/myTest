/**
 * TODO
 */
package com.xeezee.design.bridge;

/**
 * @author luoqinglong
 * @date 2014-4-8
 */
public abstract class AbstractCar implements Car
{
	Engin engin;

	public AbstractCar(Engin engin)
	{
		this.engin = engin;
	}

	@Override
	public void start()
	{
		System.out.println("AbstractCar.start()");
		this.engin.start();

	}

	@Override
	public void stop()
	{
		System.out.println("AbstractCar.stop()");
		this.engin.stop();

	}

}
