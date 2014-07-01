/**
 * TODO
 */
package com.xeezee.batch.write;

import java.io.File;
import java.io.IOException;

/**
 * @author luoqinglong
 * @date 2013-4-22
 */
public class FileUtils {
	public static void createFile(String path, String fileName) throws IOException {

		File file = new File(path + "/" + fileName);
		file.createNewFile();
	}

	public static void delFile(String path, String fileName) throws IOException {

		File file = new File(path + "/" + fileName);
		if (file.exists()) {
			file.delete();
		}

	}

	public static void main(String[] arg) {

	}
}
