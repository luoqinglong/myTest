/**
 * TODO
 */
package com.xeezee.executor;

import java.security.SecureRandom;

/**
 * 线程池测试类
 * 
 * @author luoqinglong
 * @date 2014-2-25
 */
public class Test
{
	private static final char[] PRINTABLE_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ012345679"
			.toCharArray();

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// ExecutorService executors = Executors.newSingleThreadExecutor();
		// Future<Integer> future = executors.submit(new TaxCallable());
		// System.out.println(222);
		// executors.shutdown();
		SecureRandom randomizer = new SecureRandom();
		byte[] random = new byte[10];

		for (int i = 0; i < 10; i++)
		{
			randomizer.nextBytes(random);
			System.out.println(Test.convertBytesToString(random));
		}

	}

	private static String convertBytesToString(final byte[] random)
	{
		final char[] output = new char[random.length];
		for (int i = 0; i < random.length; i++)
		{
			final int index = Math.abs(random[i] % Test.PRINTABLE_CHARACTERS.length);
			output[i] = Test.PRINTABLE_CHARACTERS[index];
		}

		return new String(output);
	}
}
