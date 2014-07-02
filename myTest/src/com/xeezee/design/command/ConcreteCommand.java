/**
 * TODO
 */
package com.xeezee.design.command;

/**
 * 命令
 * 
 * @author luoqinglong
 * @date 2014-4-11
 */
public class ConcreteCommand implements Command
{
	private final Receiver receiver;

	public ConcreteCommand(Receiver receiver)
	{
		this.receiver = receiver;
	}

	/*
	 * (non-Javadoc)
	 * @see com.xeezee.design.command.Command#execute()
	 */
	@Override
	public void execute()
	{
		System.out.println("处理命令");
		this.receiver.action();

	}
}
