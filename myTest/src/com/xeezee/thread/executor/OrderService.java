/**
 * TODO
 */
package com.xeezee.thread.executor;

/**
 * 订单处理业务类
 * 
 * @author luoqinglong
 * @date 2014-3-23
 */
public class OrderService
{
	/**
	 * 按照会员下单的顺序处理订单
	 */
	public synchronized void dealOrder()
	{
		String memberId = Test.getBuyQueue().poll();
		// System.out.println(Thread.currentThread().getName() + "开始处理订单，会员号： " + memberId);
		try
		{
			// 模拟业务处理时长
			Thread.sleep(4000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("---处理完成订单，会员号： " + memberId);
		if (Test.getBuyQueue().size() == 0)
		{
			Test.getExecutorService().shutdown();
		}
	}
}
