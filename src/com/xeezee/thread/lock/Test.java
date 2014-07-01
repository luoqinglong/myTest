/**
 * TODO
 */
package com.xeezee.thread.lock;

/**
 * @author luoqinglong
 * @date 2014-4-25
 */
public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		LockThread lock1 = new LockThread();
		LockThread lock2 = new LockThread();
		lock1.add();
		lock2.add();

		SynThread synThread1 = new SynThread();
		SynThread synThread2 = new SynThread();
		synThread1.add();
		synThread2.add();
	}

}
