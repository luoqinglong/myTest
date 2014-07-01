/**
 * TODO
 */
package com.xeezee.design.template;

/**
 * 模板方法
 * 
 * @author luoqinglong
 * @date 2014-4-10
 */
public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Account cd = new CDAccount();
		Account money = new MoneyMarketAccount();
		System.out.println("cd:" + cd.calculateInterest());
		System.out.println("money:" + money.calculateInterest());
	}
}
