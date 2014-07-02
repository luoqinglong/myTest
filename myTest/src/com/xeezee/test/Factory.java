/**
 * TODO
 */
package com.xeezee.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author luoqinglong
 * @date 2012-7-7
 */
public class Factory {
	private static Factory factory;
	private static Object object = new Object();

	private Factory() {
	}

	public static Factory getFactory(int i) {
		synchronized (Factory.object) {
			if (Factory.factory == null) {
				try {
					// System.out.println(i);
					Thread.sleep(100);
					Factory.factory = new Factory();
					System.out.println(i);
				} catch (InterruptedException e) {

					// e.printStackTrace();
				}
			}
			return Factory.factory;
		}
	}

	public static void main(String[] args) {
		// Factory factory = Factory.getFactory(1);

		// Factory factory1 = Factory.getFactory(2);

		// Factory factory2 = Factory.getFactory(3);
		for (int i = 0; i < 100; i++) {
			FactoryManage factoryManage = new FactoryManage(i);
			// System.out.println(Thread.currentThread().getName());
			factoryManage.start();
		}
		String aString = "1981-12-01";
		Pattern pattern = Pattern.compile("^\\d{4}-((0[1-9]{1})|(1[0-2]{1}))-((0[1-9]{1})|(1[0-2]{1}))$");
		Matcher m = pattern.matcher(aString);
		System.out.println(m.matches());

	}
}

class FactoryManage extends Thread {
	private int i = 0;

	public FactoryManage(int num) {
		this.i = num;
	}

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName());
		Factory.getFactory(this.i);
	}

}
