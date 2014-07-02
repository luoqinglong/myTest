/**
 * TODO
 */
package com.xeezee.encrypt;


/**
 * @author luoqinglong
 * @date 2014-3-6
 */
public class T
{
	// 加密移位参照
	static final String STR_AZ = "0123456789ABCDEFGHIGKLMNOPQRSTUVWXYZ";
	static char[] ssTemp;

	// 加密
	public String encrypt(String s)
	{
		StringBuffer ss = new StringBuffer();
		for (int i = 0; i < s.length(); i++)
		{
			char tempi = s.charAt(i);
			for (int j = 0; j < T.STR_AZ.length(); j++)
			{
				// 大于最大位后，从初的A取。形成循环
				if (tempi == T.STR_AZ.charAt(j))
				{
					if ((j + 3) >= T.STR_AZ.length())
					{
						int z = j + 3 - T.STR_AZ.length();
						ss.append(T.STR_AZ.charAt(z));
					}
					else
					{
						ss.append(T.STR_AZ.charAt(j + 3));
					}
				}
			}
		}
		return ss.toString();
	}

	// 解密
	public String decrypt(String s)
	{
		StringBuffer ssde = new StringBuffer();
		for (int i = 0; i < s.length(); i++)
		{
			char tempi = s.charAt(i);
			for (int j = 0; j < T.STR_AZ.length(); j++)
			{
				if (tempi == T.STR_AZ.charAt(j))
				{
					// 小于最小位后，从最大的Z取，形成循环
					if ((j - 3) < 0)
					{
						int z = T.STR_AZ.length() + (j - 3);
						ssde.append(T.STR_AZ.charAt(z));
					}
					else
					{
						ssde.append(T.STR_AZ.charAt(j - 3));
					}
				}
			}
		}
		return ssde.toString();
	}

	public static void main(String[] args)
	{

		T move3 = new T();
		move3.t("001");
		move3.t("002");
		move3.t("003");
	}

	public void t(String s)
	{
		String s1 = s;
		System.out.println("内容：" + s);
		String esString = this.encrypt(s1);
		System.out.println("密码：" + esString);
		String eString = this.decrypt(esString);
		System.out.println("解密：");
		System.out.println(eString);
	}

}
