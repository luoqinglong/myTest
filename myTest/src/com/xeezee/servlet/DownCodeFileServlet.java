package com.xeezee.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Description
 * 
 * @author luoqinglong
 * @date 2013-4-20 下午5:44:31
 * @since 1.0
 */
public class DownCodeFileServlet extends HttpServlet {
	private static final Logger logger = Logger.getLogger(DownCodeFileServlet.class);

	/**
	 * Constructor of the object.
	 */
	public DownCodeFileServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	@Override
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String filePath = "d:/testCode" + File.separator;
			String snId = req.getParameter("snId");
			String sn = req.getParameter("sn");
			String fileName = snId + "_" + sn + ".txt";
			File file = new File(filePath + "211_HB000002.txt");
			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(file));

			resp.addHeader("Content-Disposition", "attachment;filename="
					+ new String(fileName.getBytes("utf-8"), "ISO-8859-1"));
			resp.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(resp.getOutputStream());
			resp.setContentType("application/octet-stream");
			int offset = 0;
			int length = -1;
			final int size = 1024;
			byte[] buffer = new byte[size];

			while ((length = fis.read(buffer)) != -1) {
				toClient.write(buffer);
				offset += length;
			}
			fis.close();
			toClient.close();

		} catch (Exception e) {
			DownCodeFileServlet.logger.error("文件下载失败！", e);
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException if an error occurs
	 */
	@Override
	public void init() throws ServletException {
		// Put your code here
	}

}
