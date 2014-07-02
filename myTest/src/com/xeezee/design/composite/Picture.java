/**
 * TODO
 */
package com.xeezee.design.composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 树枝构件
 * 
 * @author luoqinglong
 * @date 2014-4-9
 */
public class Picture implements Graphics
{
	private final Vector<Graphics> composites = new Vector<Graphics>();

	public Enumeration<Graphics> compenents()
	{
		return this.composites.elements();
	}

	@Override
	public void draw()
	{
		System.out.println("树枝方法");
		for (int i = 0; i < this.composites.size(); i++)
		{
			this.composites.get(i).draw();
		}

	}

	@Override
	public void add(Graphics graphics)
	{
		this.composites.add(graphics);

	}

	@Override
	public void remove(Graphics graphics)
	{
		this.composites.remove(graphics);

	}

	@Override
	public Graphics getChild(int index)
	{
		// TODO Auto-generated method stub
		return this.composites.get(index);
	}

}
