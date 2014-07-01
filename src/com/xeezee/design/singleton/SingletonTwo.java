/**
 * TODO
 */
package com.xeezee.design.singleton;

/**
 * 懒汉
 * 
 * @author luoqinglong
 * @date 2014-3-19
 */
public class SingletonTwo
{
	private static SingletonTwo s;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public synchronized static SingletonTwo getInstance()
	{
		if (SingletonTwo.s == null)
		{
			SingletonTwo.s = new SingletonTwo();
		}
		return SingletonTwo.s;
	}
}
