package com.xeezee;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Send extends HttpServlet
{

	/**
	 * TODO
	 */
	private static final long serialVersionUID = 965399181321613052L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{

		String reqUrl = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort()
				+ req.getContextPath() + "/return";
		HttpRequestProxy httpRequestProxy = new HttpRequestProxy();

		System.out.println("__sent:" + reqUrl);
		String ret = httpRequestProxy.sendPost(reqUrl, "name=luoqinglong&id=1234");
		System.out.println("__sentContent:" + ret);

		OutputStream out = resp.getOutputStream();
		resp.setContentType("application/octet-stream; charset=utf-8");
		// resp.setHeader(s, s1)
		String string = "12345";
		out.write(string.getBytes());
		out.flush();
		out.close();
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies)
		{
			System.out.println(cookie.getValue());
		}

	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}

}
