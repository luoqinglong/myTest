/**
 * TODO
 */
package com.xeezee.design.observer;

import java.util.Observable;

/**
 * 被观察者
 * 
 * @author luoqinglong
 * @date 2014-4-18
 */
public class Watched extends Observable
{
	private String data = "";

	public String getData()
	{
		return this.data;
	}

	public void changeData(String data)
	{
		if (!this.data.equals(data))
		{
			this.data = data;
			this.setChanged();
		}
		this.notifyObservers();
	}
}
