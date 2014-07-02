/**
 * TODO
 */
package com.xeezee.obj;

/**
 * @author luoqinglong
 * @date 2012-8-4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(5678);
		while (true) {
			Socket client = server.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream());
			ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
			ObjectOutputStream objectOutput = new ObjectOutputStream(client.getOutputStream());
			while (true) {

				String str = in.readLine();
				try {
					objectInputStream.readObject();

					objectOutput.writeObject(new Object());
					objectOutput.flush();

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(str);
				out.println("has receive....");
				out.flush();
				if (str.equals("end")) {
					break;
				}
			}
			client.close();
		}
	}
}