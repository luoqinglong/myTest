/**
 * TODO
 */
package com.xeezee.reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author luoqinglong
 * @date 2013-7-19
 */
public class TestReg
{
	// http://www.cnblogs.com/playing/archive/2011/03/15/1984943.html
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String orgString = "http://baidu.com/yiqi/ETRGDFWETGFD";
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");
		Matcher matcher = pattern.matcher(orgString);
		if (matcher.find())
		{
			System.out.println(matcher.group());
		}
		for (String string : pattern.split(orgString))
		{
			System.out.println(string);
		}

	}

}
