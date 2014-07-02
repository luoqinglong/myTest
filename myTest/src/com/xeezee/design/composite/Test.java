/**
 * TODO
 */
package com.xeezee.design.composite;

/**
 * 组合模式
 * 
 * @author luoqinglong
 * @date 2014-4-8
 * @url
 * @des 整体-部分
 */
public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Graphics picture = new Picture();
		Graphics line = new Line();
		Graphics circle = new Circle();
		picture.add(line);
		picture.add(circle);
		picture.draw();
	}
}
