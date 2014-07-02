package com.xeezee.batch.write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * Description 码信息业务处理
 * 
 * @author luoqinglong
 * @date 2013-4-20 下午1:50:36
 * @since 1.0
 */
public class CodeInfoService {
	private static final Logger logger = Logger.getLogger(CodeInfoService.class);

	/***
	 * 
	 * Description:删除并生成txt码文件
	 * 
	 * @param snId 批次id 211
	 * @param sn 批次号 hb000001
	 * @return
	 */
	public boolean createCodeFile(String snId, String sn) {
		String tmpsql = null;
		boolean flag = false;
		String sqlTemplate = "select content codeContent from CODE_INFO where sn='%s' LIMIT %d,%d";
		// get database connection
		Connection connection = null;
		try {
			connection = DBUtil.getConn();
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		Statement statement = null;
		ResultSet rs = null;
		long startIndex = 0;
		// 一次读取条数
		int readSize = 100000;
		long pageNo = 0;
		String path = "D:/testCode";
		// 1、 初始化环境，删除历史文件
		String fileName = snId + "_" + sn + ".txt";
		// 临时文件前缀
		String tmpFileName = "tmp" + "_" + fileName;
		// 删除已经存在的码文件
		try {
			FileUtils.delFile(path, fileName);
			FileUtils.delFile(path, tmpFileName);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		RandomAccessFile mm = null;
		FileOutputStream out = null;
		// 2、创建目录和文件
		// FileUtils.createDir(path);
		try {
			FileUtils.createFile(path, tmpFileName);
			mm = new RandomAccessFile(path + File.separator + tmpFileName, "rw");
		} catch (IOException e1) {
			CodeInfoService.logger.error("生成码值文件时失败！" + path + File.separator + tmpFileName, e1);
		}

		try {
			statement = connection.createStatement();
			while (true) {
				pageNo++;
				startIndex = (pageNo - 1) * readSize;
				tmpsql = String.format(sqlTemplate, new Object[] { snId, startIndex, readSize });
				if (CodeInfoService.logger.isDebugEnabled()) {
					CodeInfoService.logger.debug("写码文件的sql语句:" + tmpsql);
				}

				rs = statement.executeQuery(tmpsql);
				// 数据循环记录器
				int count = 0;
				// 写码值到临时文件
				// out = new FileOutputStream(path + File.separator + tmpFileName, true);
				while (rs.next()) {
					count++;
					// 写到码值文件

					StringBuffer sb = new StringBuffer();
					sb.append(rs.getString("codeContent"));
					sb.append("\r\n");
					mm.write(sb.toString().getBytes("utf-8"));
					// out.write(sb.toString().getBytes("utf-8"));

				}

				if (count < readSize || pageNo > 25) {
					break;
				}
			}
			// out.close();
			File tmpFile = new File(path + File.separator + tmpFileName);
			File codeFile = new File(path + File.separator + fileName);
			// tmpFile.
			org.apache.commons.io.FileUtils.copyFile(tmpFile, codeFile);

			flag = true;
		} catch (SQLException e) {
			CodeInfoService.logger.error("码批次数据查询异常!查询sql:" + tmpsql, e);
		} catch (FileNotFoundException e) {
			CodeInfoService.logger.error("无法生成码文件,文件名：" + path + File.separator + tmpFileName, e);
		} catch (IOException e) {
			CodeInfoService.logger.error("码值文件写入错误！数据：[" + path + File.separator + tmpFileName + "]", e);
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeConnection(connection);
			if (mm != null) {
				try {
					mm.close();
					FileUtils.delFile(path, tmpFileName);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return flag;
	}

	public boolean createCodeStreamFile(String snId, String sn) {
		String tmpsql = null;
		boolean flag = false;
		String sqlTemplate = "select content codeContent from CODE_INFO where sn='%s' LIMIT %d,%d";
		// get database connection
		Connection connection = null;
		try {
			connection = DBUtil.getConn();
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		Statement statement = null;
		ResultSet rs = null;
		long startIndex = 0;
		// 一次读取条数
		int readSize = 100000;
		long pageNo = 0;
		String path = "D:/testCode";
		// 1、 初始化环境，删除历史文件
		String fileName = snId + "_" + sn + ".txt";
		// 临时文件前缀
		String tmpFileName = "tmp" + "_" + fileName;
		// 删除已经存在的码文件
		try {
			FileUtils.delFile(path, fileName);
			FileUtils.delFile(path, tmpFileName);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		RandomAccessFile mm = null;
		FileOutputStream out = null;
		// 2、创建目录和文件
		// FileUtils.createDir(path);
		// try {
		// //FileUtils.createFile(path, tmpFileName);
		// } catch (IOException e1) {
		// CodeInfoService.logger.error("生成码值文件时失败！" + path + File.separator + tmpFileName, e1);
		// }

		try {
			statement = connection.createStatement();
			out = new FileOutputStream(path + File.separator + tmpFileName, true);
			while (true) {
				pageNo++;
				startIndex = (pageNo - 1) * readSize;
				tmpsql = String.format(sqlTemplate, new Object[] { snId, startIndex, readSize });
				if (CodeInfoService.logger.isDebugEnabled()) {
					CodeInfoService.logger.debug("写码文件的sql语句:" + tmpsql);
				}

				rs = statement.executeQuery(tmpsql);
				// 数据循环记录器
				int count = 0;
				// 写码值到临时文件

				while (rs.next()) {
					count++;
					// 写到码值文件

					StringBuffer sb = new StringBuffer();
					sb.append(rs.getString("codeContent"));
					sb.append("\r\n");
					// mm.write(sb.toString().getBytes("utf-8"));
					out.write(sb.toString().getBytes("utf-8"));

				}

				if (count < readSize || pageNo > 15) {
					break;
				}
			}

			flag = true;
		} catch (SQLException e) {
			CodeInfoService.logger.error("码批次数据查询异常!查询sql:" + tmpsql, e);
		} catch (FileNotFoundException e) {
			CodeInfoService.logger.error("无法生成码文件,文件名：" + path + File.separator + tmpFileName, e);
		} catch (IOException e) {
			CodeInfoService.logger.error("码值文件写入错误！数据：[" + path + File.separator + tmpFileName + "]", e);
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeConnection(connection);
			if (out != null) {
				try {
					out.close();
					File tmpFile = new File(path + File.separator + tmpFileName);
					File codeFile = new File(path + File.separator + fileName);
					org.apache.commons.io.FileUtils.copyFile(tmpFile, codeFile);
					tmpFile.delete();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return flag;
	}

	public static void main(String[] arg) {
		String sqlTemplate = "insert into CODE_INFO ( sn_id,code_content,random,creator,create_date) values( 213,'httP://hbssfsdfsf33333333333',234234,'sdfsdf' ,'2013-04-20 17:10:42' )";
		// get database connection
		// Connection connection =
		// DBConnection.getConnection(DBConnection.MYSQL);
		// Statement statement;
		// try
		// {
		// statement = connection.createStatement();
		// statement.execute(sqlTemplate);
		// }
		// catch (SQLException e)
		// {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// finally
		// {
		// DBConnection.closeConnection(connection);
		// }

		File file1 = new File("D:\\createCode\\tmp_252_hb020130422002.txt");
		File file2 = new File("D:\\createCode\\252_hb020130422002.txt");
		file1.renameTo(file2);
		System.out.println(111);

	}

}
