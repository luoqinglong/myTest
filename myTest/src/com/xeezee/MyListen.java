package com.xeezee;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListen implements HttpSessionListener
{

	@Override
	public void sessionCreated(HttpSessionEvent arg0)
	{
		// TODO Auto-generated method stub
		HttpSession session = arg0.getSession();
		session.setMaxInactiveInterval(60);
		Date date = new Date();
		System.out.println("创建session!" + date + ",sessionId:" + session.getId());

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0)
	{
		// TODO Auto-generated method stub
		HttpSession session = arg0.getSession();
		Date date = new Date();
		System.out.println("销毁session!" + date + ",sessionId:" + session.getId());

	}

}
