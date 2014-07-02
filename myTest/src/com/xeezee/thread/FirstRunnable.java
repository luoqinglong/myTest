/**
 * TODO
 */
package com.xeezee.thread;

/**
 * @author luoqinglong
 * @date 2013-3-17
 */
public class FirstRunnable implements Runnable
{
	public Integer count;

	public FirstRunnable(Integer count)
	{
		this.count = count;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		synchronized (this.count)
		{

			for (int i = 0; i < 5; i++)
			{
				System.out.println("FirstRunnable:" + this.count);
				this.count++;
			}
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
