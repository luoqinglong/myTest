package com.xeezee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequestProxy
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	/**
	 * 发送post请求
	 * 
	 * @param reUrl 请求地址
	 * @param params 请求参数
	 * @return
	 */

	public String sendPost(String reUrl, String params)
	{

		URL url = null;
		String retContent = null;
		try
		{
			// 建立请求连接
			url = new URL(reUrl);
			HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
			urlCon.setRequestMethod("POST");
			urlCon.setReadTimeout(5000);
			urlCon.setDoOutput(true);
			// 发送请求参数
			byte[] b = params.getBytes();
			urlCon.getOutputStream().write(b, 0, b.length);
			urlCon.getOutputStream().flush();
			urlCon.getOutputStream().close();

			// 读取返回结果
			InputStream in = urlCon.getInputStream();

			BufferedReader rd = new BufferedReader(new InputStreamReader(in, "utf-8"));

			StringBuffer tempStr = new StringBuffer();
			String crlf = System.getProperty("line.separator");
			System.out.println("__" + crlf);
			String tempLine = null;
			while ((tempLine = rd.readLine()) != null)
			{
				tempStr.append(tempLine);
				// tempStr.append(crlf);

			}
			retContent = tempStr.toString();

		}
		catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * StringBuffer paramBuffer = new StringBuffer(); for (Iterator ite = params.entrySet().iterator();
		 * ite.hasNext();) { Entry entry = (Entry) ite.next(); paramBuffer.append(entry); }
		 */

		return retContent;
	}
}
