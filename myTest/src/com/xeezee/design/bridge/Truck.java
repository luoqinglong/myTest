/**
 * TODO
 */
package com.xeezee.design.bridge;

/**
 * @author luoqinglong
 * @date 2014-4-8
 */
public class Truck extends AbstractCar
{

	/**
	 * @param engin
	 */
	public Truck(Engin engin)
	{
		super(engin);
	}

	public void loadGoods()
	{
		System.out.println("Truck.loadGoods()");
	}
}
