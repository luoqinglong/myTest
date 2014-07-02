/**
 * TODO
 */
package com.xeezee.design.builder;

/**
 * @author luoqinglong
 * @date 2014-3-18
 */
public class CarBBuilder implements CarBuilder
{
	private final Car product;

	public CarBBuilder()
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
		this.product.glass = new JapaneseGlass();

	}

	/*
	 * (non-Javadoc)
	 * @see com.xeezee.design.builder.CarBuilder#buildWheel()
	 */
	@Override
	public void buildWheel()
	{
		this.product.wheel = new AmericanWheel();

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
