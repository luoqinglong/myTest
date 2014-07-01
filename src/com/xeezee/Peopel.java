package com.xeezee;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class Peopel implements ServletRequestAttributeListener, HttpSessionAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent servletrequestattributeevent) {
		// TODO Auto-generated method stub
		System.out.println("request.attributeAdded..........");

	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent servletrequestattributeevent) {
		// TODO Auto-generated method stub
		System.out.println("request.attributeRemoved..........");

	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent servletrequestattributeevent) {
		// TODO Auto-generated method stub
		System.out.println("request.attributeReplaced..........");

	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent httpsessionbindingevent) {
		// TODO Auto-generated method stub
		System.out.println("session.attributeAdded..........");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent httpsessionbindingevent) {
		// TODO Auto-generated method stub
		System.out.println("session.attributeRemoved..........");

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent httpsessionbindingevent) {
		// TODO Auto-generated method stub
		System.out.println("session.attributeReplaced..........");

	}

}
