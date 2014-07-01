/**
 * TODO
 */
package com.xeezee.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * rmi业务处理类
 * 
 * @author luoqinglong
 * @date 2012-8-4
 */
public class RmiMonitorServiceImpl extends UnicastRemoteObject implements RmiService
{

	/**
	 * TODO
	 */
	private static final long serialVersionUID = 1337728809991017681L;
	static int num = 0;

	/**
	 * @throws RemoteException
	 */
	protected RmiMonitorServiceImpl() throws RemoteException
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 业务方法
	 * 
	 * @see com.xeezee.rmi.server.RmiService#interActive()
	 */
	@Override
	public String interActive() throws RemoteException
	{
		System.out.println("rmi业务实现：" + (RmiMonitorServiceImpl.num++));
		return "hello rmi";
	}

}
