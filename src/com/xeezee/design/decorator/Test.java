/**
 * TODO
 */
package com.xeezee.design.decorator;

/**
 * 装饰模式（增强功能）
 * 
 * @author luoqinglong
 * @date 2014-4-9
 */
public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Component component = new ConcreteDecoratorA(new ConcreteComponent());
		Component componentB = new ConcreteDecoratorB(component);
		componentB.operation();

	}

}
