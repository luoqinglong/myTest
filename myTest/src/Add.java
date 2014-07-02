import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Add
{
	public static boolean isUnique(int x)
	{
		char[] k = String.valueOf(x).toCharArray();

		Set<Character> s = new HashSet<Character>();
		for (int i = 0; i < k.length; i++)
		{
			s.add(k[i]);
		}
		if (s.size() == 5)
		{
			return true;
		}
		return false;
	}

	public static boolean isUnique(int x, int y)
	{
		char[] xA = String.valueOf(x).toCharArray();
		char[] yA = String.valueOf(y).toCharArray();

		Set<Character> s = new HashSet<Character>();
		for (int i = 0; i < xA.length; i++)
		{
			s.add(xA[i]);
		}
		for (int i = 0; i < yA.length; i++)
		{
			s.add(yA[i]);
		}

		if (s.size() == 10)
		{
			return true;
		}
		return false;
	}

	public static void main(String[] args)
	{
		Integer a = new Integer(1);
		Integer b = new Integer(1);
		Random r = new Random(1);
		System.out.println(r.nextInt(9));
	}// main
}
