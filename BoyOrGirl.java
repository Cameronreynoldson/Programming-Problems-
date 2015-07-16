import java.util.*; 

public class BoyOrGirl
{
	public static void main(String[] args)
	{
		HashSet<Character> set = new HashSet<Character>();
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		for(int i = 0; i < s.length(); ++i)
		{
			set.add(s.charAt(i));
		}

		if(set.size()%2 == 0)
			System.out.println("CHAT WITH HER!");
		else
			System.out.println("IGNORE HIM!");
	}
}
