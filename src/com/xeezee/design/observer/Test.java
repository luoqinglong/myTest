/**
 * TODO
 */
package com.xeezee.design.observer;

/**
 * 观察者模式
 * 
 * @author luoqinglong
 * @date 2014-4-18
 * @des 一对多的依赖，当一个对象改变时，所有关联对象都改变
 */
public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Watched watched = new Watched();
		Watcher watcher = new Watcher(watched);
		watched.changeData("In C");
	}
}
