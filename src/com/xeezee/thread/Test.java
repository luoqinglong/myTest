/**
 * TODO
 */
package com.xeezee.thread;

/**
 * 不同线程中的同一监视器
 * 
 * @author luoqinglong
 * @date 2013-3-17
 */
public class Test
{
	private final int a;

	public Test()
	{
		this.a = 90;
	}

	public static void main(String arg[]) throws InterruptedException
	{
		// Integer count = new Integer(0);
		Integer count = new Integer(155);
		SecondRunnable s = new SecondRunnable(count);
		FirstRunnable f = new FirstRunnable(count);
		Thread ft = new Thread(f);
		Thread st = new Thread(s);

		ft.start();

		st.start();

		// Test.add(count);
		// System.out.println("  main:" + count);
		// System.out.println(" ----------");

		// Person person = new Person(12);
		// Test.addP(person);
		// System.out.println("  m-age:" + person.age);

	}

	public static void add(Integer c)
	{
		c++;
		System.out.println("  add:" + c);

	}

	public static void addP(Person p)
	{
		p.age++;
		System.out.println("  age:" + p.age);

	}
}
