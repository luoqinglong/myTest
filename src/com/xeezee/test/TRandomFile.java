/**
 * TODO
 */
package com.xeezee.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author luoqinglong
 * @date 2012-6-22
 */
public class TRandomFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RandomAccessFile raf = null;

		try {
			raf = new RandomAccessFile("123.txt", "rw");
			raf.seek(raf.length() - 5);
			raf.write("\r\n3333333333333333333,".getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (raf != null) {
					raf.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
