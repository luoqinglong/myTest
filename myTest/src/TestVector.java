/**
 * TODO
 */

/**
 * @author luoqinglong
 * @date 2013-9-28
 */
public class TestVector
{
	public static void main(String[] arg)
	{
		Vector a1 = new Vector(1, 2, 3);
		System.out.println("第一个向量：" + a1.toString());

		Vector a2 = new Vector(4, 5, 6);
		System.out.println("第二个向量：" + a2.toString());

		a1.add(a2);
		System.out.println("向      量    和：" + a1.toString());
		int pp = 9 / 10;
		String ss = String.valueOf(pp);
		System.out.println(TestVector.get(10000));
	}

	public static int[] get(int x)
	{
		int s[] = new int[5];
		int i = 0;
		while (x != 0)
		{
			s[i] = x % 10;
			System.out.println(s[i]);
			x /= 10;
			i++;
		}
		return s;
	}
}

class Vector
{
	private int a;
	private int b;
	private int c;

	public Vector(int a, int b, int c)
	{
		this.a = a;
		this.b = b;
		this.c = c;

	}

	public void add(Vector v)
	{
		this.a = this.a + v.a;
		this.b = this.b + v.b;
		this.c = this.c + v.c;
	}

	public int getA()
	{
		return this.a;
	}

	public void setA(int a)
	{
		this.a = a;
	}

	public int getB()
	{
		return this.b;
	}

	public void setB(int b)
	{
		this.b = b;
	}

	public int getC()
	{
		return this.c;
	}

	public void setC(int c)
	{
		this.c = c;
	}

	@Override
	public String toString()
	{
		return "Vector [a=" + this.a + ", b=" + this.b + ", c=" + this.c + "]";
	}

}
