/**
 * TODO
 */

/**
 * @author luoqinglong
 * @date 2014-1-2
 */
public class Person
{

	String cc = "f";

	public Person()
	{

	}

	public Person(String a)
	{
		this();
	}

	public Person(String a, String b)
	{

	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// Person.cc = "222";
		Person l = new Person("aa", "");

	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.cc == null) ? 0 : this.cc.hashCode());
		return 1;
	}

	@Override
	public boolean equals(Object obj)
	{

		return true;
	}
}
