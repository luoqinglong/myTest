/**
 * TODO
 */
package com.xeezee.thread;

/**
 * @author luoqinglong
 * @date 2013-3-17
 */
public class SecondRunnable implements Runnable {
	public Integer count;

	public SecondRunnable(Integer count) {
		this.count = count;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		synchronized (this.count) {

			for (int i = 0; i < 5; i++) {
				System.out.println("  SecondRunnable:" + this.count);
				this.count++;
			}

		}

	}
}
