/**
 * TODO
 */
package com.xeezee.design.command;

/**
 * 命令模式
 * 
 * @author luoqinglong
 * @date 2014-4-11
 */
public class Test
{
	public static void main(String[] args)
	{
		Receiver receiver = new Receiver();
		Command command = new ConcreteCommand(receiver);
		Invoker invoker = new Invoker(command);
		invoker.action();
	}
}
