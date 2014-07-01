/**
 * TODO
 */
package com.xeezee.rmi.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author luoqinglong
 * @date 2012-8-4
 */
public class RMIServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 8180;
		String ipString = "localhost";
		try {
			LocateRegistry.createRegistry(port);
			RmiService rmiService = new RmiMonitorServiceImpl();
			Naming.bind("rmi://" + ipString + ":" + port + "/comm", rmiService);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
