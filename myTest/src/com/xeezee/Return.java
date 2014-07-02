package com.xeezee;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Return extends HttpServlet {

	/**
	 * TODO
	 */
	private static final long serialVersionUID = 4851026466892084793L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nameString = req.getParameter("name");
		String id = URLDecoder.decode(req.getParameter("id"));// ;
		System.out.println("name:" + nameString + ",id:" + id);

		this.doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		out.print("fffff");

	}
}
