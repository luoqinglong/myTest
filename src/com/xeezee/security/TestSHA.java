/**
 * TODO
 */
package com.xeezee.security;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.axiom.util.base64.Base64Utils;
import org.apache.commons.codec.binary.Base64;

/**
 * @author luoqinglong
 * @date 2014-3-17
 */
public class TestSHA
{

	// a weak key
	private final static Base64 base64encoder = new Base64();
	// private final static BASE64Decoder base64decoder = new BASE64Decoder();
	private final static String encoding = "gbk";

	// private final static String sKey = "123456789";

	/**
	 * 加密字符串
	 */
	public static String ebotongEncrypto(String str, String sKey)
	{
		String result = str;
		if (str != null && str.length() > 0)
		{
			try
			{
				byte[] encodeByte = TestSHA.symmetricEncrypto(str.getBytes(TestSHA.encoding), sKey);
				result = TestSHA.base64encoder.encodeToString(encodeByte);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 解密字符串
	 */
	public static String ebotongDecrypto(String str, String sKey)
	{
		String result = str;
		if (str != null && str.length() > 0)
		{
			try
			{
				byte[] encodeByte = Base64Utils.decode(str);
				byte[] decoder = EbotongSecurity.symmetricDecrypto(encodeByte, sKey);
				result = new String(decoder, TestSHA.encoding);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 对称加密方法
	 * 
	 * @param byteSource 需要加密的数据
	 * @return 经过加密的数据
	 * @throws Exception
	 */
	public static byte[] symmetricEncrypto(byte[] byteSource, String sKey) throws Exception
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try
		{
			int mode = Cipher.ENCRYPT_MODE;
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			byte[] keyData = sKey.getBytes();
			DESKeySpec keySpec = new DESKeySpec(keyData);
			Key key = keyFactory.generateSecret(keySpec);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(mode, key);
			byte[] result = cipher.doFinal(byteSource);
			// int blockSize = cipher.getBlockSize();
			// int position = 0;
			// int length = byteSource.length;
			// boolean more = true;
			// while (more) {
			// if (position + blockSize <= length) {
			// baos.write(cipher.update(byteSource, position, blockSize));
			// position += blockSize;
			// } else {
			// more = false;
			// }
			// }
			// if (position < length) {
			// baos.write(cipher.doFinal(byteSource, position, length
			// - position));
			// } else {
			// baos.write(cipher.doFinal());
			// }
			// return baos.toByteArray();
			return result;
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			baos.close();
		}
	}

	/**
	 * 对称解密方法
	 * 
	 * @param byteSource 需要解密的数据
	 * @return 经过解密的数据
	 * @throws Exception
	 */
	public static byte[] symmetricDecrypto(byte[] byteSource, String sKey) throws Exception
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try
		{
			int mode = Cipher.DECRYPT_MODE;
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			byte[] keyData = sKey.getBytes();
			DESKeySpec keySpec = new DESKeySpec(keyData);
			Key key = keyFactory.generateSecret(keySpec);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(mode, key);
			byte[] result = cipher.doFinal(byteSource);
			// int blockSize = cipher.getBlockSize();
			// int position = 0;
			// int length = byteSource.length;
			// boolean more = true;
			// while (more) {
			// if (position + blockSize <= length) {
			// baos.write(cipher.update(byteSource, position, blockSize));
			// position += blockSize;
			// } else {
			// more = false;
			// }
			// }
			// if (position < length) {
			// baos.write(cipher.doFinal(byteSource, position, length
			// - position));
			// } else {
			// baos.write(cipher.doFinal());
			// }
			// return baos.toByteArray();
			return result;
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			baos.close();
		}
	}

	/**
	 * 散列算法
	 * 
	 * @param byteSource 需要散列计算的数据
	 * @return 经过散列计算的数据
	 * @throws Exception
	 */
	public static byte[] hashMethod(byte[] byteSource) throws Exception
	{
		try
		{
			MessageDigest currentAlgorithm = MessageDigest.getInstance("SHA-1");
			currentAlgorithm.reset();
			currentAlgorithm.update(byteSource);
			return currentAlgorithm.digest();
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	/**
	 * 测试对称加密算法
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		String sKey = "12345678";
		String str = "中华人民共和国万岁";
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = simpleDateFormat.format(date);
		long start = new Date().getTime();
		System.out.println("开始时间：" + strDate + "   毫秒数：" + start);
		// for ( int i = 0 ; i < 10000 ; i++ ) {
		String strEncrypto = TestSHA.ebotongEncrypto(str, sKey);
		System.out.println("被加密的字符串：" + str + "\r\n加密后的结果：" + strEncrypto);
		String strDecrypto = TestSHA.ebotongDecrypto(strEncrypto, sKey);
		System.out.println("解密后的结果：" + strDecrypto);
		// System.out.println(i);
		// }
		Date date2 = new Date(System.currentTimeMillis());
		String strDate2 = simpleDateFormat.format(date2);
		long start2 = new Date().getTime();
		System.out.println("结束时间：" + strDate2 + "   毫秒数：" + start2);
		long time = start2 - start;
		System.out.println("间隔时间：" + time);
		System.exit(0);
	}
}
