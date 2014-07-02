/**
 * TODO
 */
package com.xeezee.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author luoqinglong
 * @date 2012-8-4
 */
public interface RmiService extends Remote {
	public String interActive() throws RemoteException;
}
