/**
 * TODO
 */
package com.xeezee.design.builder;

/**
 * 构造模式
 * 
 * @author luoqinglong
 * @date 2014-3-18
 * @url http://blog.csdn.net/vincentzhao2009/article/details/6188420
 */
public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Car carA, carB;
		CarBuilder builderA = new CarABuilder();
		CarBuilder builderB = new CarBBuilder();
		Director director;
		director = new Director(builderA);
		carA = director.construct();
		director = new Director(builderB);
		carB = director.construct();
		System.out.println("Car A is made by:" + carA.glass + carA.wheel);
		System.out.println("Car B is made by:" + carB.glass + carB.wheel);

	}

}
