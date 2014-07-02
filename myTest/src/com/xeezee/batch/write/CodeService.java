/**
 * TODO
 */
package com.xeezee.batch.write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author luoqinglong
 * @date 2013-4-20
 */
public class CodeService {
	public boolean createFile() {
		String path = "D:/testCode";
		String fileName = "hb00001.txt";
		File directory = new File(path);
		if (!directory.exists()) {
			directory.mkdirs();

		}
		// 创建文件
		File file = new File(path + "/" + fileName);
		// if (!file.exists()) {
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// }

		FileOutputStream outputStream;
		long first = 0;
		try {
			outputStream = new FileOutputStream(file);

			while (first < 10) {
				first++;
				long second = 0;
				System.out.println("已使用内存：" + DBUtil.getUsedMemory());
				while (second < 20000) {
					second++;
					StringBuilder sb = new StringBuilder();
					sb.append("httpsdfsdf/dfgdfg/dfg/df/gdfg/dfg/dg/dfdf/g3453534535/35/35/34/53/5");
					sb.append("\n");
					outputStream.write(sb.toString().getBytes("UTF-8"));

				}
				System.out.println("已使用内存：" + DBUtil.getUsedMemory());
				outputStream.flush();
			}
			outputStream.close();

			Thread.sleep(10 * 1000);
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public static void main(String[] arg) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		System.out.println(sdf.format(new Date()));
		// CodeService.createFile();
		System.out.println(sdf.format(new Date()));
	}

	public static long getUsedMemory() {
		return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1000 * 1000);
	}
}
