/**
 * TODO
 */
package com.xeezee.exception;

/**
 * @author luoqinglong
 * @date 2013-3-18
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		My my = new My();
		System.out.println(my.get());
	}

}

class My {
	public int get() {
		try {
			return 1 / 0;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(111111111 + e.getMessage());
		} finally {
			System.out.println("fffffffffff");
		}
		return 55;
	}
}
