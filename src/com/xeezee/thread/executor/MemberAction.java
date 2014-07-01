/**
 * TODO
 */
package com.xeezee.thread.executor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 会员控制器
 * 
 * @author luoqinglong
 * @date 2014-3-23
 */
public class MemberAction
{
	/**
	 * 提交订单
	 */
	public void saveOrder(final String memberId)
	{
		// TODO INSERT DB

		try
		{
			// 排队
			// System.out.println(new Date() + "=========队列 " + memberId);
			boolean flag = Test.getBuyQueue().offer(memberId, 1, TimeUnit.SECONDS);
			System.out.println(new Date() + "=========队列添加 " + memberId + "_" + flag + "_" + Test.getBuyQueue().size());
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 增加排队人携带的任务
		Future<Map<String, Object>> map = Test.getExecutorService().submit(new Callable<Map<String, Object>>()
		{
			@Override
			public Map<String, Object> call() throws Exception
			{
				Map<String, Object> map = new HashMap<String, Object>();
				OrderService orderService = new OrderService();
				orderService.dealOrder();
				return map;
			}
		});

	}
}
