/**
 * TODO
 */
package com.xeezee.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luoqinglong
 * @date 2013-10-6
 */
public class TestHash
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		byte aa = -10;
		int bb = -10;
		int a = 5 & 4;
		int b = 5 | 12;
		int c = ~aa;
		int d = 1 ^ 4;
		int e = 1 >> 1;
		int f = 1 << 1;
		int g = 1 >>> 1;

		// System.out.println(a);
		// System.out.println(b);
		// System.out.println(c);
		// System.out.println(d);
		// System.out.println(e);
		// System.out.println(f);
		Person p1 = new Person(1);
		Person p2 = new Person(2);
		// System.out.println(p1.equals(p2));
		// System.out.println(p2.hashCode());

		Map<Person, String> map = new HashMap<Person, String>(20, 0.7f);
		map.put(p1, "1111");
		map.put(p2, "2222");

		Person p3 = new Person(2);

		System.out.println(p3.hashCode());
		System.out.println(map.size());
		System.out.println(map.get(p3));

		System.out.println(TestHash.indexFor(TestHash.hash(p3.hashCode()), 20));
		System.out.println(TestHash.indexFor(TestHash.hash(p3.hashCode()), 20));

	}

	static int hash(int h)
	{
		// This function ensures that hashCodes that differ only by
		// constant multiples at each bit position have a bounded
		// number of collisions (approximately 8 at default load factor).
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

	static int indexFor(int h, int length)
	{
		return h & (length - 1);
	}
}
