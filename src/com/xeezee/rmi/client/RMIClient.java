/**
 * TODO
 */
package com.xeezee.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.xeezee.rmi.server.RmiService;

/**
 * @author luoqinglong
 * @date 2012-8-4
 */
public class RMIClient
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int port = 8180;
		// 服务器端IP
		String ip = "192.168.2.100";

		try
		{
			// 對綁定业务方法的IP进行调用，返回业务方法的代理,我们可以理解为建立连接
			RmiService monitorService = (RmiService) Naming.lookup("rmi://" + ip + ":" + port + "/comm");
			// 这一步可以形象理解为服务器传值，并取回服务器返回的值
			String ret = monitorService.interActive();
			System.out.println(ret);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NotBoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
