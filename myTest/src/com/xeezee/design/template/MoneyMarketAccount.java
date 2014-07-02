/**
 * TODO
 */
package com.xeezee.design.template;

/**
 * 具体模板类
 * 
 * @author luoqinglong
 * @date 2014-4-10
 */
public class MoneyMarketAccount extends Account
{

	/*
	 * (non-Javadoc)
	 * @see com.xeezee.design.template.Account#doCalculateAccountType()
	 */
	@Override
	protected String doCalculateAccountType()
	{
		System.out.println("MoneyMarketAccount.doCalculateAccountType()");
		return "Money Market";
	}

	/*
	 * (non-Javadoc)
	 * @see com.xeezee.design.template.Account#doCalculateInterestRate()
	 */
	@Override
	protected double doCalculateInterestRate()
	{
		System.out.println("MoneyMarketAccount.doCalculateInterestRate()");
		return 1.5d;
	}

}
