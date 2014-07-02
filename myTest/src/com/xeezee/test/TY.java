/**
 * TODO
 */
package com.xeezee.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author luoqinglong
 * @date 2012-6-29
 */
public class TY extends AbstractOld {
	int i;

	TY(int a) {
		this.i = a;
	}

	/*
	 * (non-Javadoc)
	 * @see com.xeezee.test.AbstractOld#cc()
	 */
	@Override
	public void cc() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		TY ty = new TY(2);
		Integer integer = Integer.valueOf("1");
		Integer integer2 = 1;

		String aString = new String("12345");
		String bString = aString;
		bString = new String("3333");

		Integer aInteger = new Integer(1111);
		Integer bInteger = aInteger;
		bInteger = 2222;

		List aList = new ArrayList<String>();
		aList.add("1");

		List bList = aList;
		bList.add("33");

		String cString = "123";
		String dString = "1";
		float aShort = 0.4f - 0.1f;
		Integer aa = 12;
		System.out.println(Integer.toString(59, 16));
		// System.out.println("00" + Integer.toString(14, 2));
		// TT[] integers = { new TT(), new TT(), new TT() };
		List<TT> list = new ArrayList<TT>();
		list.add(new TT());
		list.add(new TT());
		list.add(new TT());
		list.add(new TT());
		Object[] objects = list.toArray();

		String[] integers1 = new String[19];
		Collections.sort(list);
		Arrays.sort(objects);
		System.out.println(((Comparable) objects[1]).compareTo(objects[2]) > 0);

		// /System.out.println(((Comparable) integers[1]).compareTo(integers[2]) > 0);

	}
}
