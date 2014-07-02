/**
 * TODO
 */
package com.xeezee.proxy.jdk;

/**
 * 主题业务类
 * 
 * @author luoqinglong
 * @date 2013-9-28
 */
public class DBQueryImpl implements IDBQuery, IDB, IQuery
{

	/*
	 * (non-Javadoc)
	 * @see com.xeezee.proxy.jdk.IDBQuery#request()
	 */
	@Override
	public Object request()
	{
		System.out.println("dbqueryimpl.....request");
		return "method [request] in " + DBQueryImpl.class;
	}

	@Override
	public Object find()
	{
		System.out.println("dbqueryimpl.....find");
		return "method [find] in " + DBQueryImpl.class;
	}

	@Override
	public Object add()
	{
		System.out.println("dbqueryimpl.....add");
		return "method [add] in " + DBQueryImpl.class;
	}

	@Override
	public Object del()
	{
		System.out.println("dbqueryimpl.....del");
		return "method [del] in " + DBQueryImpl.class;
	}

}
