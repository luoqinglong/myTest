/**
 * TODO
 */
package com.xeezee.design.decorator;

/**
 * 装饰类
 * 
 * @author luoqinglong
 * @date 2014-4-9
 */
public class Decorator implements Component
{
	private final Component component;

	public Decorator(Component component)
	{
		this.component = component;
	}

	@Override
	public void operation()
	{
		// TODO something
		System.out.println("Decorator 前置增强");
		this.component.operation();
		System.out.println("Decorator 后置增强");
		// TODO something

	}
}
