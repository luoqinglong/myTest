/**
 * TODO
 */
package com.xeezee.design.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者
 * 
 * @author luoqinglong
 * @date 2014-4-18
 */
public class Watcher implements Observer
{
	public Watcher(Watched w)
	{
		w.addObserver(this);
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg)
	{
		System.out.println("data has been changed to " + ((Watched) o).getData());
	}

}
