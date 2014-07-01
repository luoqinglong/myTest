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
public class CDAccount extends Account
{

	/*
	 * (non-Javadoc)
	 * @see com.xeezee.design.template.Account#doCalculateAccountType()
	 */
	@Override
	protected String doCalculateAccountType()
	{
		System.out.println("CDAccount.doCalculateAccountType()");
		return "CD Market";
	}

	/*
	 * (non-Javadoc)
	 * @see com.xeezee.design.template.Account#doCalculateInterestRate()
	 */
	@Override
	protected double doCalculateInterestRate()
	{
		System.out.println("CDAccount.doCalculateInterestRate()");
		return 5.5d;
	}

}
