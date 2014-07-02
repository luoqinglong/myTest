/**
 * TODO
 */
package com.xeezee.executor;

import java.util.concurrent.Callable;

/**
 * @author luoqinglong
 * @date 2014-2-25
 */
public class TaxCallable implements Callable<Integer>
{

	/*
	 * (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public Integer call() throws Exception
	{
		Integer resultCode = 110;
		System.out.println("线程开始执行任务!");
		int i = 0;
		while (i < 100)
		{
			StringBuffer aBuffer = new StringBuffer();
			System.out.println("aBuffer!" + aBuffer);
			i++;

		}
		return resultCode;
	}
}
