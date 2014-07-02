package com.xeezee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionListener;

public class TServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Peopel peopel = new Peopel();
		// req.setAttribute("qq", peopel);
		// req.removeAttribute("qq");
		HttpSession session = req.getSession();
		session.setAttribute("ddd", peopel);
		System.out.println("service...........get");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.write("nihao");
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
