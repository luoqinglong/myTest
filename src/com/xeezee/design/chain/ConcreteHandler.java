/**
 * TODO
 */
package com.xeezee.design.chain;

/**
 * @author luoqinglong
 * @date 2014-4-10
 */
public class ConcreteHandler extends Handler
{

	/**
	 * @param name
	 */
	public ConcreteHandler(String name)
	{
		super(name);
	}

	/*
	 * (non-Javadoc)
	 * @see com.xeezee.design.chain.Handler#handleRequest()
	 */
	@Override
	public void handleRequest()
	{
		if (this.getSuccessor() != null)
		{
			System.out.println(this.name + " the request is passed to " + this.getSuccessor());
			this.getSuccessor().handleRequest();
		}
		else
		{
			System.out.println(this.name + " the request is handled here  ");
		}

	}

}
