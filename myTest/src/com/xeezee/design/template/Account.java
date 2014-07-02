/**
 * TODO
 */
package com.xeezee.design.template;

/**
 * 抽象模板
 * 
 * @author luoqinglong
 * @date 2014-4-10
 */
public abstract class Account
{
	protected String accountNumber;

	public Account(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public Account()
	{
	}

	public double calculateInterest()
	{
		double rate = this.doCalculateInterestRate();
		String type = this.doCalculateAccountType();
		double amount = this.calculateAmount(type, this.accountNumber);
		return rate * amount;
	}

	abstract protected String doCalculateAccountType();

	abstract protected double doCalculateInterestRate();

	public double calculateAmount(String type, String accountNumber)
	{
		return 123.0d;
	}

}
