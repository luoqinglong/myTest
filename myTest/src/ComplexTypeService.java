import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * TODO
 */

/**
 * @author luoqinglong
 * @date 2012-8-9
 */
public class ComplexTypeService {

	/**
	 * 
	 * @return
	 */
	public boolean uploadImageWithByte(byte[] imageByte, int length) {
		FileOutputStream foStream = null;
		try {
			foStream = new FileOutputStream("d:\\111.jpg");
			foStream.write(imageByte, 0, length);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			if (foStream != null) {
				try {
					foStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return true;
	}

	public String[] getArray() {
		String[] strArray = new String[] { "自行车", "飞机", "火箭" };
		return strArray;
	}

	/**
	 * 
	 * @return
	 */
	public String[] getMDArray() {
		String[] strArray = new String[] { "自行车,飞机,火箭", "中国,美国,德国", "超人,蜘蛛侠,钢铁侠" };
		return strArray;
	}

	public DataForm getDataForm() {
		return new DataForm();
	}

	public byte[] getDataFormBytes() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(baos);
		objectOutputStream.writeObject(new DataForm());
		return baos.toByteArray();

	}
}
