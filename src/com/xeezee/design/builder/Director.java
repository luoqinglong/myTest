/**
 * TODO
 */
package com.xeezee.design.builder;

/**
 * @author luoqinglong
 * @date 2014-3-18
 */
public class Director
{
	private final CarBuilder builder;

	public Director(CarBuilder builder)
	{
		this.builder = builder;
	}

	public Car construct()
	{
		return this.builder.getProduct();
	}
}
