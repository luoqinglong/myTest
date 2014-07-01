/**
 * TODO
 */
package com.xeezee.design.adapter;


/**
 * 适配器模式
 * 
 * @author luoqinglong
 * @date 2014-4-2
 * @url http://www.blogjava.net/EvanLiu/archive/2008/01/31/178673.html
 */
public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Adapter adapter = new Adapter(new Adaptee());
		adapter.methodA();

	}
}
