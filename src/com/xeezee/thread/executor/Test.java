/**
 * TODO
 */
package com.xeezee.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author luoqinglong
 * @date 2014-3-23
 */
public class Test
{
	private static ExecutorService executor = null;

	private static BuyQueue buyQueue = null;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// System.out.println("===========开始发送请求 ");
		for (int i = 0; i < 10; i++)
		{

			MemberAction action = new MemberAction();
			action.saveOrder(i + 1 + "");
		}
		// System.out.println("=========请求发送完毕 ");
	}

	public static synchronized ExecutorService getExecutorService()
	{
		if (Test.executor == null)
		{
			Test.executor = Executors.newFixedThreadPool(1);
		}
		return Test.executor;
	}

	public static synchronized BuyQueue getBuyQueue()
	{
		if (Test.buyQueue == null)
		{
			Test.buyQueue = new BuyQueue(1);
		}
		return Test.buyQueue;
	}
}
