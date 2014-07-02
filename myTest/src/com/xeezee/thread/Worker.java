/**
 * TODO
 */
package com.xeezee.thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 多线程等待
 * 
 * @author luoqinglong
 * @date 2014-3-23
 */
public class Worker implements Runnable
{
	private final CyclicBarrier cyclicBarrier;

	public Worker(CyclicBarrier cb)
	{
		this.cyclicBarrier = cb;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		try
		{
			Thread.sleep(new Random().nextInt(5000));
		}
		catch (InterruptedException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "到达汇合点");

		try
		{
			this.cyclicBarrier.await();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		catch (BrokenBarrierException e)
		{
			e.printStackTrace();
		}

	}
}
