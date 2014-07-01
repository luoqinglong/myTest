/**
 * TODO
 */
package com.xeezee.test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author luoqinglong
 * @date 2012-6-20
 */
public class TT implements Comparable
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Integer integer = new Integer(1);

		TT.flition();
		byte i = 'A';
		char a = 'k';
		switch (a) {
		case 'A':
			System.out.println("1111111");
			// break;
		case 'b':
			System.out.println("22222");
			// break;
		case 'c':
			System.out.println("3333");
			// break;
		case 'd':
			System.out.println("44444");
			break;

		default:
			System.out.println("555");
			// break;
		}
		// int a = 1 + (++i);

	}

	/**
	 * 
	 */
	private static void geta(StringBuffer stringBuffer)
	{
		stringBuffer = new StringBuffer();
		stringBuffer.append("aaaa");

	}

	public static int getC(final Circle circle)
	{

		return circle.geti();
	}

	public static int flition()
	{
		FileInputStream fis;

		try
		{
			fis = new FileInputStream("ff.txt");
			fis.read();
			return 9999;
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(2222222);
			return 9999;
		}
		finally
		{

			System.out.println(Math.sqrt(10));

		}
		// System.out.println(4444);
		// /return 111;

	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object o)
	{
		// TODO Auto-generated method stub
		return 0;
	}

}

class Circle
{
	int i;

	public int geti()
	{
		return this.i++;
	}

}
