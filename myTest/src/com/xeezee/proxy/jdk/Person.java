/**
 * TODO
 */
package com.xeezee.proxy.jdk;

import java.util.Hashtable;

/**
 * @author luoqinglong
 * @date 2013-10-6
 */
public class Person
{
	int age;
	Hashtable<Integer, Person> cache = new Hashtable<Integer, Person>();

	public Person()
	{
	}

	public Person(Integer age)
	{

	}

	public Person valueOf(Integer age)
	{
		if (this.cache.containsKey(age))
		{
			return this.cache.get(age);
		}
		else
		{
			Person person = new Person();
			this.cache.put(age, person);
			return person;
		}
	}
}
