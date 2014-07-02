/**
 * TODO
 */
package com.xeezee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author luoqinglong
 * @date 2012-7-20
 */
public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies = req.getCookies();
		String userId = req.getParameter("userid");
		if (userId == null || "".equals(userId)) {
			userId = "123";
		}
		boolean newUser = true;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getValue());
				if (cookie.getName().equals("userid")) {
					cookie.setDomain(".baidu.com");
					System.out.println("-----" + cookie.getDomain());
					// newUser = false;
					// break;
				}
			}
		}

		if (newUser) {

			Cookie cookie = new Cookie("userid", userId);
			cookie.setMaxAge(30);

			resp.addCookie(cookie);
		}

		resp.sendRedirect("index.jsp");

	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub

		super.service(arg0, arg1);
	}
}
