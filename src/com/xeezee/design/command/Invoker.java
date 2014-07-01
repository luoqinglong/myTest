/**
 * TODO
 */
package com.xeezee.design.command;

/**
 * 请求者
 * 
 * @author luoqinglong
 * @date 2014-4-11
 */
public class Invoker
{
	private final Command command;

	public Invoker(Command command)
	{
		this.command = command;
	}

	/**
	 * 行动方法
	 */
	public void action()
	{
		System.out.println("请求者开始");
		this.command.execute();
	}
}
