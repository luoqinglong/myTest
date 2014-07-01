/**
 * TODO
 */
package com.xeezee.design.bridge;

/**
 * @author luoqinglong
 * @date 2014-4-8
 */
public class Bus extends AbstractCar
{

	/**
	 * @param engin
	 */
	public Bus(Engin engin)
	{
		super(engin);
	}

	public void loadPeople()
	{
		System.out.println("Bus.loadPeople()");
	}
}
