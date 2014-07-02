/**
 * TODO
 */

/**
 * @author luoqinglong
 * @date 2014-4-9
 */
public class TestFinal
{
	final int f;

	public TestFinal()
	{
		this.f = 1;
	}

	public void doSomething()
	{
		System.out.println("f=" + this.f);
	}

	public static void main(String args[])
	{
		TestFinal test = new TestFinal();
		test.doSomething();
	}

}
