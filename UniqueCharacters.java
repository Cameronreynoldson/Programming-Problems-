import java.util.*; 

public class UniqueCharacters
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		boolean[] present = new boolean[265];
		String s = scanner.next();
		System.out.println(solve(present,s));
	}

	private static boolean solve(boolean[] present, String s)
	{
		for(int i = 0; i < s.length(); ++i)
		{
			int index = (int) s.charAt(i);
			if(present[index])
				return false; 
			else
				present[index] = true; 
		}

		return true; 
	}
}
