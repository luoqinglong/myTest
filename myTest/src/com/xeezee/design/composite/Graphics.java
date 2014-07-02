/**
 * TODO
 */
package com.xeezee.design.composite;

/**
 * 抽象构件--定义接口和默认行为(透明模式)
 * 
 * @author luoqinglong
 * @date 2014-4-9
 */
public interface Graphics
{

	public void draw();

	public void add(Graphics graphics);

	public void remove(Graphics graphics);

	public Graphics getChild(int index);
}
