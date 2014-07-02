/**
 * TODO
 */
package com.xeezee.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author luoqinglong
 * @date 2013-5-1
 */
public class FileUtil {
	public static void main(String[] arg) {
		// FileUtil.writeFile();
		// /FileUtil.writeFileByte();
		try {
			FileUtil.ww();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void writeFileByte() {
		String fileName = "d:/testCode/123.txt";
		OutputStream toClient;
		try {
			toClient = new BufferedOutputStream(new FileOutputStream(new File(fileName)));
			// toClient.write((2 + "\n").getBytes(), 13, 1);

			// toClient.flush();
			toClient.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void readFile(String fileName) {

	}

	public static void writeFile() {
		String fileName = "d:/testCode/123.txt";
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream(new File(fileName));
			OutputStream toClient = new BufferedOutputStream(outputStream);

			int line = 0;
			while (line < 3000) {
				line++;
				toClient.write((line + "\n").getBytes());
			}
			toClient.flush();
			toClient.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void ww() throws IOException {
		String filePath = "d:/testCode" + File.separator;
		File file = new File(filePath + "123.txt");
		InputStream fis = new BufferedInputStream(new FileInputStream(file));
		OutputStream toClient = new BufferedOutputStream(new FileOutputStream("d:/testCode/222.txt"));

		// FileOutputStream toClient = new FileOutputStream("d:/testCode/222.txt");
		final int size = 1024;
		byte[] buffer = new byte[100];
		int length = -1;
		while ((length = fis.read(buffer)) != -1) {
			toClient.write(buffer);
			toClient.write("22".getBytes());
			// toClient.write(buffer);
			// toClient.write("\n".getBytes());
		}
		fis.close();
		toClient.close();

	}
}
