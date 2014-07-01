/**
 * TODO
 */
package com.xeezee.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author luoqinglong
 * @date 2014-3-6
 */
public class AscTestEncrypt
{
	public static String byte2hex(byte[] b)
	{

		String hs = "";

		String stmp = "";

		for (int n = 0; n < b.length; n++)
		{

			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));

			if (stmp.length() == 1)
			{
				hs = hs + "0" + stmp;
			}
			else
			{

				hs = hs + stmp;
			}
		}
		return hs;
	}

	/**
	 * 加密
	 */
	public static byte[] encrypt(String content, String password)
	{

		try
		{

			KeyGenerator kgen = KeyGenerator.getInstance("AES");

			kgen.init(128, new SecureRandom(password.getBytes()));

			SecretKey secretKey = kgen.generateKey();

			byte[] enCodeFormat = secretKey.getEncoded();

			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");

			Cipher cipher = Cipher.getInstance("AES");// 创建密码器

			byte[] byteContent = content.getBytes("utf-8");

			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化

			byte[] result = cipher.doFinal(byteContent);

			return result; // 加密

		}
		catch (NoSuchAlgorithmException e)
		{

			e.printStackTrace();

		}
		catch (NoSuchPaddingException e)
		{

			e.printStackTrace();

		}
		catch (InvalidKeyException e)
		{

			e.printStackTrace();

		}
		catch (UnsupportedEncodingException e)
		{

			e.printStackTrace();

		}
		catch (IllegalBlockSizeException e)
		{

			e.printStackTrace();

		}
		catch (BadPaddingException e)
		{

			e.printStackTrace();

		}

		return null;

	}

	/**
	 * 解密
	 * 
	 * @param content
	 * @param password
	 * @return
	 */
	public static byte[] decrypt(byte[] content, String password)
	{

		try
		{

			KeyGenerator kgen = KeyGenerator.getInstance("AES");

			kgen.init(128, new SecureRandom(password.getBytes()));

			SecretKey secretKey = kgen.generateKey();

			byte[] enCodeFormat = secretKey.getEncoded();

			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");

			Cipher cipher = Cipher.getInstance("AES");// 创建密码器

			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化

			byte[] result = cipher.doFinal(content);

			return result; // 解密

		}
		catch (NoSuchAlgorithmException e)
		{

			e.printStackTrace();

		}
		catch (NoSuchPaddingException e)
		{

			e.printStackTrace();

		}
		catch (InvalidKeyException e)
		{

			e.printStackTrace();

		}
		catch (IllegalBlockSizeException e)
		{

			e.printStackTrace();

		}
		catch (BadPaddingException e)
		{

			e.printStackTrace();

		}
		return null;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// 需要加密的内容
		String content = "0002";
		// 加密密码
		String password = "1111111111111111";
		byte[] encryptContent = content.getBytes();
		byte[] decryptContent = AscTestEncrypt.encrypt(content, password);
		System.out.println(AscTestEncrypt.byte2hex(decryptContent));

	}

}
