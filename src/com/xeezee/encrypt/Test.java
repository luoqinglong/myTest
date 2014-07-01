/**
 * TODO
 */
package com.xeezee.encrypt;

/**
 * @author luoqinglong
 * @date 2014-3-6
 */
public class Test
{

	public static void main(String[] args)
	{
		Test.e("00001");
		Test.e("00002");
		Test.e("00003");

	}

	public static String e(String s)
	{
		System.out.println(" 内容：" + s);
		char[] inputArr = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < inputArr.length; i++)
		{// 将各个字符加密
			int charInt = Integer.valueOf(inputArr[i]);
			int charIntEn = charInt * 2 + 10;
			if (charIntEn > 120)
			{
				sb.append((char) (charIntEn / 3));
			}
			else
			{
				sb.append((char) (charIntEn));
			}
		}

		System.out.println("未倒序加密后内容：" + sb.toString());

		for (int begin = 0, end = sb.length() - 1; begin < sb.length() / 2; begin++, end--)
		{// 倒序算法
			char temp;
			temp = sb.charAt(begin);
			sb.setCharAt(begin, sb.charAt(end));
			sb.setCharAt(end, temp);
		}

		System.out.println("最终加密后内容为：" + sb.toString());
		return sb.toString();
	}
}
