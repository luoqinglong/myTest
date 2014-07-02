/**
 * TODO
 */
package com.xeezee.design.absfactory;

/**
 * 抽象工厂
 * 
 * @author luoqinglong
 * @date 2014-3-18
 * @url http://www.ibm.com/developerworks/cn/java/designpattern/factory/
 */
public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		AbstractFactory factory = new MySQLFactory();
		factory.getDao().delete();
		AbstractFactory factory2 = new OracleFactory();
		factory2.getDao().delete();
	}

}
