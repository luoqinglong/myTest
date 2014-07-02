/**
 * TODO
 */
package com.xeezee.thread.lock;

import java.util.Date;

/**
 * @author luoqinglong
 * @date 2014-4-25
 */
public class SynThread
{

	public synchronized void add()
	{
		System.out.println(Thread.currentThread().getName() + "_SynThread.add_" + (new Date()));
		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void del()
	{
		System.out.println(Thread.currentThread().getName() + "_SynThread.del_" + (new Date()));
		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
