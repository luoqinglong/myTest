/**
 * TODO
 */
package com.xeezee.design.bridge;

/**
 * 桥接模式
 * 
 * @author luoqinglong
 * @date 2014-4-8
 * @url http://blog.csdn.net/superbeck/article/details/5969884
 * @des 抽象和实现分离，两者可独立改变
 */
public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Car car = new Truck(new GasolineEngine());
		Car car2 = new Truck(new DieselEngine());
		car.start();
		car2.start();

	}
}
