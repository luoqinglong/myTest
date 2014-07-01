/**
 * TODO
 */
package com.xeezee.design.decorator;

/**
 * 具体构件类
 * 
 * @author luoqinglong
 * @date 2014-4-9
 */
public class ConcreteComponent implements Component
{

	/*
	 * (non-Javadoc)
	 * @see com.xeezee.design.Decorator.Component#operation()
	 */
	@Override
	public void operation()
	{
		// write you code
		System.out.println("ConcreteComponent.operation原始业务方法");
	}

}
