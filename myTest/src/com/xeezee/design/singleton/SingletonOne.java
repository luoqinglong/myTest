/**
 * TODO
 */
package com.xeezee.design.singleton;

/**
 * 饿汉式单例
 * 
 * @author luoqinglong
 * @date 2014-3-19
 */
public class SingletonOne
{
	private static SingletonOne s = new SingletonOne();

	private SingletonOne()
	{
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public static SingletonOne getInstance()
	{
		return SingletonOne.s;
	}

}
