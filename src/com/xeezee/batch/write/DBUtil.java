/**
 * TODO
 */
package com.xeezee.batch.write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author luoqinglong
 * @date 2013-4-20
 */
public class DBUtil {

	public static String url = "jdbc:mysql://localhost:3306/codeinfo?user=root&password=root&useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false";
	public static FileOutputStream outputStream;

	public static Connection getConn() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = DriverManager.getConnection(DBUtil.url);
		return connection;
	}

	public static void insert() throws SQLException {
		Connection connection = DBUtil.getConn();
		Statement statement = connection.createStatement();
		long temp = 0L;
		int tempPageNo = 0;
		long allCount = 100000;
		long pageSize = 100000;

		int pageNo = Long.bitCount(allCount % pageSize == 0 ? (allCount / pageSize) : Long
				.bitCount(allCount / pageSize) + 1);
		// connection.setAutoCommit(false);

		while (tempPageNo < pageNo) {
			tempPageNo++;
			while (temp < pageSize) {

				temp++;
				String sql = "insert into code_info (sn,content,create_time) values (1234,'httpsdfsdf/dfgdfg/dfg/df/gdfg/dfg/dg/dfdf/g3453534535/35/35/34/53/5','2012-02-05 23:12:12')";
				statement.addBatch(sql);
			}
			statement.executeBatch();
			// connection.commit();
		}

		statement.close();
		connection.close();

	}

	public static void main(String[] art) throws SQLException {
		System.out.println(DBUtil.sdf.format(new Date()));
		// DBUtil.insert();
		DBUtil.query();
		System.out.println(DBUtil.sdf.format(new Date()));

	}

	public static void query() {
		String temple = "select sn,content from code_info where sn='%s' limit %d,%d";
		// String sql = String.format(temple, new Object[] { "1234", 0, 500000 });
		int pageNo = 1;
		int pageSize = 100000;
		Connection connection = null;
		FileOutputStream out = DBUtil.getOutputStream();

		try {
			System.out.println("创建数据连接开始:" + DBUtil.sdf.format(new Date()));
			connection = DBUtil.getConn();
			Statement statement = connection.createStatement();
			System.out.println("创建数据连接结束:" + DBUtil.sdf.format(new Date()));
			long first = pageSize;
			// while (first == pageSize) {
			while (pageNo < 31) {
				long index = (pageNo - 1) * pageSize;
				pageNo++;
				System.out.println("已使用内存：" + DBUtil.getUsedMemory());
				System.out.println("数据查询开始:" + DBUtil.sdf.format(new Date()));
				ResultSet rSet = statement.executeQuery(String.format(temple, new Object[] { "211", index, pageSize }));
				System.out.println("已使用内存：" + DBUtil.getUsedMemory());
				System.out.println("数据查询结束:" + DBUtil.sdf.format(new Date()));
				long count = 0;
				while (rSet.next()) {
					count++;
					StringBuffer sb = new StringBuffer();
					sb.append(rSet.getString("content"));
					sb.append("\n");
					out.write(sb.toString().getBytes("utf-8"));
				}
				first = count;
				System.out.println("------------------------------------已使用内存：" + DBUtil.getUsedMemory());
				out.flush();

			}
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			DBUtil.closeConnection(connection);
		}

	}

	public static long getUsedMemory() {
		return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1000 * 1000);
	}

	public static FileOutputStream getOutputStream() {
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

		try {
			DBUtil.outputStream = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DBUtil.outputStream;
	}

	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void closeResultSet(ResultSet rSet) {
		if (rSet != null) {
			try {
				rSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
}
