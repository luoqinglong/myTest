import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

/**
 * @author luoqinglong
 * @date 2012-7-29
 */
public class RPCClient {

	/**
	 * @param args
	 * @throws AxisFault
	 */
	public static void main(String[] args) throws AxisFault {
		// TODO Auto-generated method stub
		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();
		EndpointReference targetEPR = new EndpointReference("http://localhost:8080/axis2/services/SimpleService");
		options.setTo(targetEPR);

		Object[] opAddEntryArgs = new Object[] { "超人" };
		Class[] classes = new Class[] { String.class };
		QName opAddEntry = new QName("http://ws.apache.org/axis2", "getGreeting");
		System.out.println(serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0]);

	}
}
