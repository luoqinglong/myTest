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
public class ConcreteDecoratorB extends Decorator
{

	/**
	 * @param component
	 */
	public ConcreteDecoratorB(Component component)
	{
		super(component);
	}

	@Override
	public void operation()
	{
		// TODO something
		System.out.println("ConcreteDecoratorB 前置增强");
		super.operation();
		System.out.println("ConcreteDecoratorB 后置增强");
		// TODO something

	}
}
