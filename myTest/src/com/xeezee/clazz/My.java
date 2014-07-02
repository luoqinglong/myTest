/**
 * TODO
 */
package com.xeezee.clazz;

/**
 * @author luoqinglong
 * @date 2012-7-30
 */
public class My extends Thread {
	private final Object object = new Object();

	@Override
	public void run() {
		try {
			this.object.wait();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
