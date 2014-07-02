/**
 * TODO
 */
package com.xeezee.design.chain;

/**
 * @author luoqinglong
 * @date 2014-4-10
 */
public abstract class Handler
{
	protected Handler successor;
	protected String name;

	public Handler(String name)
	{
		this.name = name;
	}

	public abstract void handleRequest();

	public void setSuccessor(Handler successor)
	{
		this.successor = successor;
	}

	public Handler getSuccessor()
	{
		return this.successor;
	}
}
