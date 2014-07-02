/**
 * TODO
 */
package com.xeezee.design.factory;

/**
 * 工厂方法模式
 * 
 * @author luoqinglong
 * @date 2014-3-18
 */
public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Shape shape = ShapeFactory.createEntity("circle");
		shape.draw();
		Shape shapeOther = ShapeFactory.createEntity("square");
		shapeOther.draw();
	}

}
