/**
 * TODO
 */
package com.xeezee.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author luoqinglong
 * @date 2012-8-13
 */
public class TestReg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Pattern pattern = Pattern.compile("(\\w)\\1{2,5}");
		// Pattern pattern = Pattern.compile("\\w{2,5}");
		Pattern pattern = Pattern.compile("(?>a)");

		Matcher matcher = pattern.matcher("abcde");
		while (matcher.find()) {
			System.out.println(matcher.group(0));
		}

		System.out.println("aaaaaas".matches("a+."));
		System.out.println(Math.round(11.5));
		System.out.println(Math.round(-11.5));

		TestReg.get();

	}

	public static int get() {
		int[] aa = new int[] { 1, 2 };
		try {

			return TestReg.set();
		} catch (Exception e) {
			// TODO: handle exception
			return 333333;
		} finally {
			System.out.println(2222);
		}

	}

	public static int set() {
		System.out.println(999999);
		return 344444;
	}
}
