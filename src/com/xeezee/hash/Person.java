/**
 * TODO
 */
package com.xeezee.hash;

/**
 * @author luoqinglong
 * @date 2013-10-7
 */
public class Person
{
	int age;

	public Person(int age)
	{
		this.age = age;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + this.age;
		return 1;
	}

	@Override
	public boolean equals(Object obj)
	{

		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (this.getClass() != obj.getClass())
		{
			return false;
		}
		Person other = (Person) obj;
		if (this.age == other.age)
		{
			return true;
		}

		return false;

	}

	@Override
	public String toString()
	{
		return "Person [age=" + this.age + "]";
	}

}
