/**
 * TODO
 */
package com.xeezee.design.decorator;

/**
 * 具体装饰类
 * 
 * @author luoqinglong
 * @date 2014-4-9
 */
public class ConcreteDecoratorA extends Decorator
{

	/**
	 * @param component
	 */
	public ConcreteDecoratorA(Component component)
	{
		super(component);
	}

	@Override
	public void operation()
	{
		// TODO something
		System.out.println("ConcreteDecoratorA 前置增强");
		super.operation();
		System.out.println("ConcreteDecoratorA 后置增强");
		// TODO something

	}
}
