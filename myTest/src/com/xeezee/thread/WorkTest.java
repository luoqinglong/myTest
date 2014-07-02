/**
 * TODO
 */
package com.xeezee.thread;

import java.util.concurrent.CyclicBarrier;


/**
 * @author luoqinglong
 * @date 2014-3-23
 */
public class WorkTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		CyclicBarrier cb = new CyclicBarrier(3, new Runnable()
		{

			@Override
			public void run()
			{
				System.out.println("隧道已打通");

			}
		});
		new Thread(new Worker(cb), "工人-1").start();
		new Thread(new Worker(cb), "工人-2").start();
		new Thread(new Worker(cb), "工人-3").start();
	}
}
