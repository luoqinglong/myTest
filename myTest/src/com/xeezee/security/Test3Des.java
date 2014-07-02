/**
 * TODO
 */
package com.xeezee.security;

import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author luoqinglong
 * @date 2014-3-17
 */
public class Test3Des
{

	private static final BASE64Encoder base64 = new BASE64Encoder();

	private static final Cipher initCipher()
	{

		try
		{

			// 添加新安全算法:PKCS7

			// Security.addProvider(new 　org.bouncycastle.jce.provider.BouncyCastleProvider());

			String algorithm = "DESede/ECB/PKCS7Padding";

			SecretKey desKey = new SecretKeySpec((new BASE64Decoder()).decodeBuffer("密钥"), algorithm);

			Cipher tcipher = Cipher.getInstance(algorithm);

			tcipher.init(Cipher.ENCRYPT_MODE, desKey);

			return tcipher;

		}
		catch (Exception e)
		{

			e.printStackTrace();

		}

		return null;

	}

	public static void main(String[] args) throws IOException
	{
		System.out.println(Test3Des.base64.encode("00000002".getBytes()));
	}

}
