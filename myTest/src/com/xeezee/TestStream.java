package com.xeezee;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * String reqUrl = "http://interface.feecenter.cn:5000/feechange"; String params =
		 * "Protocol=010001&COID=1234&PacketID=12&Ver=0&Platform=MT6205&VmVer=0&IMSI=423423423&Mobile=13698658754&SmsCenter=10658754875&PayFee=10&CanSupport=1&RequestFrom=1&Carrier=&GatewayIP=&GatewayKW=PhoneFactoryName=&ChannelMaxNum=0&FeePolicy=021"
		 * ; HttpRequestProxy httpRequestProxy = new HttpRequestProxy();
		 * 
		 * System.out.println("__sent:" + reqUrl);
		 * 
		 * String ret = httpRequestProxy.sendPost(reqUrl, params);
		 * 
		 * System.out.println("__sentContent:" + ret); public static String getNextMonthR(String fmt) { String str = "";
		 * SimpleDateFormat sdf = new SimpleDateFormat(fmt); Calendar lastDate = Calendar.getInstance(); lastDate.add(2,
		 * 1); lastDate.set(5, (new Random()).nextInt(20) % 20 + 1); str = sdf.format(lastDate.getTime()); return str; }
		 ***/

		String sdateString = TestStream.getCurrentMonthR2("yyyy-MM-dd");

		Map<String, String> sMap = new HashMap<String, String>();
		sMap.put("a", "bbbb");
		String str = "25";
		Integer a = new Random().nextInt(Integer.valueOf(str)) % (6) + Integer.valueOf(str) - 5;

		Calendar iastDate = Calendar.getInstance();
		iastDate.set(Calendar.DATE, 28);
		iastDate.roll(Calendar.DATE, 3);
		str = new SimpleDateFormat("yyyyMMdd").format(iastDate.getTime());
		double s = 1200000000d;
		double f = 200 / 100;
		String imsi = "1987654";
		String imsiTmp = imsi.charAt(0) == '9' ? imsi.substring(1) : imsi;
		String ssString = "rrrr,ttttt,yyyy,,uuuuu";
		System.out.println(f);

	}

	public static String getNextMonthR(String fmt) {

		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		Calendar lastDate = Calendar.getInstance();
		lastDate.add(2, 1);
		lastDate.set(5, (new Random()).nextInt(20) % 20 + 1);
		str = sdf.format(lastDate.getTime());
		return str;
	}

	private static boolean isLast5Days() {
		boolean ret = false;
		String str = "";
		Calendar iastDate = Calendar.getInstance();
		iastDate.set(Calendar.DATE, 1);
		iastDate.roll(Calendar.DATE, -1);
		str = new SimpleDateFormat("dd").format(iastDate.getTime());
		int max0 = Integer.valueOf(str);
		int min0 = max0 - 4;
		System.out.println("11__sentContent:" + min0);
		ret = Integer.valueOf(new SimpleDateFormat("dd").format(new Date())) >= min0;
		return ret;
	}

	public static String getCurrentMonthR2(String fmt) {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);

		Calendar iastDate = Calendar.getInstance();
		iastDate.set(Calendar.DATE, 1);
		iastDate.roll(Calendar.DATE, -1);
		str = new SimpleDateFormat("dd").format(iastDate.getTime());
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(
				Calendar.DATE,
				new Random().nextInt(Integer.valueOf(str) + 5 - 3 - 2)
						% (Integer.valueOf(str) + 5 - 3 - 2 - (Integer.valueOf(str) + 5 - 3 - 2 - 5) + 1 + 2 - 1 - 1)
						+ Integer.valueOf(str) + 5 - 3 - 2 - 5);
		str = sdf.format(lastDate.getTime());
		return str;
	}

}
