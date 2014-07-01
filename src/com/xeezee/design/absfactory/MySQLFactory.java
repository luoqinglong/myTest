/**
 * TODO
 */
package com.xeezee.design.absfactory;

/**
 * @author luoqinglong
 * @date 2014-3-18
 */
public class MySQLFactory extends AbstractFactory
{

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.xeezee.design.absfactory.AbstractFactory#getDao()
	 */
	@Override
	DAO1 getDao()
	{
		// TODO Auto-generated method stub
		return new MySQLDAO1();
	}

}
