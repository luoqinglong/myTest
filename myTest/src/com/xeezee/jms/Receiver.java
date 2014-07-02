/**
 * TODO
 */
package com.xeezee.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author luoqinglong
 * @date 2012-7-16
 */
public class Receiver {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Receiver receiver = new Receiver();
		try {
			receiver.receive();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void receive() throws NamingException {
		InitialContext initContext = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) initContext.lookup("connectionFactoryNames");
		Destination destination = (Destination) initContext.lookup("java.naming.provider.url");
		initContext.close();
		try {
			Connection connection = factory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageConsumer messageConsumer = session.createConsumer(destination);

			TextMessage message = (TextMessage) messageConsumer.receive();
			System.out.println(message.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
