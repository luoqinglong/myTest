import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

/**
 * TODO
 */

/**
 * @author luoqinglong
 * @date 2012-8-9
 */
public class ComplexTypeRPCClient {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RPCServiceClient serviceClient = null;
		try {
			serviceClient = new RPCServiceClient();
		} catch (AxisFault e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Options options = serviceClient.getOptions();
		EndpointReference targetEPR = new EndpointReference("http://localhost:8080/axis2/services/ComplexTypeService");
		options.setTo(targetEPR);
		/******************* 1、上传图像 ************/

		try {
			File file = new File("d:\\222.jpg");
			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[(int) file.length()];

			int n = fis.read(buffer);

			Object[] opAddEntryArgs = new Object[] { buffer, n };
			Class[] classes = new Class[] { Boolean.class };
			QName opAddEntry = new QName("http://ws.apache.org/axis2", "uploadImageWithByte");
			fis.close();
			// 开始上传图像文件，并输出uploadImageWithByte方法的返回传
			System.out.println(serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0]);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/******************* 2、读取一维数组 ***********************/
		QName opAddEntry = new QName("http://ws.apache.org/axis2", "getArray");
		String[] strArray = null;
		try {
			strArray = (String[]) serviceClient.invokeBlocking(opAddEntry, new Object[] {},
					new Class[] { String[].class })[0];
		} catch (AxisFault e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (String s : strArray) {
			System.out.print(s + "  ");
		}
		System.out.println();

		/******************* 3、读取二维数组 ***********************/
		opAddEntry = new QName("http://ws.apache.org/axis2", "getMDArray");
		try {
			strArray = (String[]) serviceClient.invokeBlocking(opAddEntry, new Object[] {},
					new Class[] { String[].class })[0];
		} catch (AxisFault e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (String s : strArray) {
			String[] array = s.split(",");
			for (String ss : array) {
				System.out.print("<" + ss + "> ");
			}
			System.out.println();
		}
		System.out.println();

		/******************* 4、返回DataForm对象实例 ****************/
		opAddEntry = new QName("http://ws.apache.org/axis2", "getDataForm");
		DataForm df = null;
		try {
			df = (DataForm) serviceClient.invokeBlocking(opAddEntry, new Object[] {}, new Class[] { DataForm.class })[0];
		} catch (AxisFault e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(df.getAge() + "__" + df.getName());

		/******************* 5、返回对象字节数组 ********************/
		opAddEntry = new QName("http://ws.apache.org/axis2", "getDataFormBytes");
		byte[] buffer = null;
		try {
			buffer = (byte[]) serviceClient.invokeBlocking(opAddEntry, new Object[] {}, new Class[] { byte[].class })[0];

			ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buffer));
			df = (DataForm) ois.readObject();
			System.out.println(df.getName());

		} catch (AxisFault e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
