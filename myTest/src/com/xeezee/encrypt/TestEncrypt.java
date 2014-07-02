/**
 * TODO
 */
package com.xeezee.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * @author luoqinglong
 * @date 2014-3-6
 */
public class TestEncrypt
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			byte[] r = TestEncrypt.encrypt("1".getBytes(), "ftgeeeeet".getBytes());
			try
			{
				System.out.println(new String(r, "utf-8"));
			}
			catch (UnsupportedEncodingException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch (InvalidKeyException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NoSuchAlgorithmException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NoSuchPaddingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InvalidKeySpecException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalBlockSizeException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (BadPaddingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static byte[] encrypt(byte[] src, byte[] key) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeySpecException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		SecureRandom sr = new SecureRandom();
		DESKeySpec dks = new DESKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey securekey = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

		return cipher.doFinal(src);
	}

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
}
