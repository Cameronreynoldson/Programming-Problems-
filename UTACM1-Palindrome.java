import java.util.*; 

public class UTACM1-Palindrome
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for(int i = 0; i < t; ++i)
		{
			String s = scanner.next();
			canBePal(s);
		}
	}

	public static void canBePal(String s)
	{	
		int count = 0; 

		for(int i = 0; i < s.length() / 2; ++i)
		{
			if(s.charAt(i) != s.charAt(s.length()-1-i))
			{
				count++;
			}
		}

		if(count > 1)
			System.out.println("NO");
		else
			System.out.println("YES");
	}
}
