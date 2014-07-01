/**
 * TODO
 */
package com.xeezee.thread.lock;

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author luoqinglong
 * @date 2014-4-25
 */
public class LockThread
{
	ReentrantLock lock = new ReentrantLock();

	public void add()
	{
		try
		{
			this.lock.lock();
			System.out.println(Thread.currentThread().getName() + "_LockThread.add_" + (new Date()));
			try
			{
				Thread.sleep(3000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		finally
		{
			this.lock.unlock();
		}

	}

	public void del()
	{
		try
		{
			this.lock.lock();
			System.out.println(Thread.currentThread().getName() + "_LockThread.del_" + (new Date()));
			try
			{
				Thread.sleep(3000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		finally
		{
			this.lock.unlock();
		}

	}
}
