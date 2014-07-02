/**
 * TODO
 */
package com.xeezee.design.builder;

/**
 * @author luoqinglong
 * @date 2014-3-18
 */
public class CarABuilder implements CarBuilder
{
	private Car product = null;

	public CarABuilder()
	{
		this.product = new Car();
	}

	/*
	 * (non-Javadoc)
	 * @see com.xeezee.design.builder.CarBuilder#buildGlass()
	 */
	@Override
	public void buildGlass()
	{
		this.product.glass = new AmericanGlass();
	}

	/*
	 * (non-Javadoc)
	 * @see com.xeezee.design.builder.CarBuilder#buildWheel()
	 */
	@Override
	public void buildWheel()
	{
		this.product.wheel = new JapaneseWheel();

	}

	/*
	 * (non-Javadoc)
	 * @see com.xeezee.design.builder.CarBuilder#getProduct()
	 */
	@Override
	public Car getProduct()
	{
		this.buildGlass();
		this.buildWheel();
		return this.product;
	}

}
