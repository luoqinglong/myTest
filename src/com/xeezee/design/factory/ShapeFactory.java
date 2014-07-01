/**
 * TODO
 */
package com.xeezee.design.factory;

/**
 * 工厂构造器
 * 
 * @author luoqinglong
 * @date 2014-3-18
 */
public class ShapeFactory
{
	public ShapeFactory()
	{
	}

	/**
	 * 不同参数构造不同的类
	 * 
	 * @param type
	 * @return
	 */

	public static Shape createEntity(String type)
	{
		if (type.equals("circle"))
		{
			return new Circle();
		}
		else
		{
			return new Square();
		}
	}
}
