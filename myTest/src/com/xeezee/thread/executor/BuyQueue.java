/**
 * TODO
 */
package com.xeezee.thread.executor;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 排队器
 * 
 * @author luoqinglong
 * @date 2014-3-23
 */
public class BuyQueue extends ArrayBlockingQueue<String>
{

	/**
	 * @param capacity
	 */
	public BuyQueue(int capacity)
	{
		super(capacity);
		// TODO Auto-generated constructor stub
	}

}
