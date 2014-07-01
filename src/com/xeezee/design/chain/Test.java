/**
 * TODO
 */
package com.xeezee.design.chain;

/**
 * 责任链模式
 * 
 * @author luoqinglong
 * @date 2014-4-10
 */
public class Test
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Handler handler1 = new ConcreteHandler("handler1");
		Handler handler2 = new ConcreteHandler("handler2");
		Handler handler3 = new ConcreteHandler("handler3");
		handler1.setSuccessor(handler2);
		handler3.setSuccessor(handler1);
		handler3.handleRequest();
	}

}
