package com.xeezee.webservice;

/**
 * TODO
 */

/**
 * @author luoqinglong
 * @date 2012-7-28
 */
public class MyService {
	public String getName(String name) {
		return "myService:" + name;
	}

	public void update() {
		System.out.println("myService:update();");
	}

}
