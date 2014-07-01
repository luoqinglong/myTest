/**
 * TODO
 */
package com.xeezee.design.composite;

/**
 * 树叶构件
 * 
 * @author luoqinglong
 * @date 2014-4-9
 */
public class Circle implements Graphics
{

	@Override
	public void draw()
	{
		System.out.println("Circle.draw()");

	}

	@Override
	public void add(Graphics graphics)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Graphics graphics)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Graphics getChild(int index)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
