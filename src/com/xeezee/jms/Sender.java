/**
 * TODO
 */
package com.xeezee.jms;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author luoqinglong
 * @date 2012-7-16
 */
public class Sender {
	private static final String connectFactory = "connectionFactoryNames";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sender sender = new Sender();
		try {

			sender.send("1111111111111");

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void send(String msg) throws NamingException, FileNotFoundException {
		InputStream inputStream = ClassLoader.getSystemResourceAsStream("jndi.properties");// /new DataInputStream(new
																							// FileInputStream("jndi.properties"));
		Properties properties = new Properties();
		try {
			properties.load(inputStream);

			System.out.println(properties.getProperty("connectionFactoryNames"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		InitialContext initContext = new InitialContext(properties);
		ConnectionFactory factory = (ConnectionFactory) initContext.lookup("connectionFactoryNames");
		Destination destination = (Destination) initContext.lookup("java.naming.provider.url");
		initContext.close();
		try {
			Connection connection = factory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = session.createProducer(destination);

			Message message = session.createTextMessage(msg);
			messageProducer.send(message);

		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
