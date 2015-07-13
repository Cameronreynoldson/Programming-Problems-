import java.util.*; 

public class TableStones
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int stones = scanner.nextInt();
		String s = scanner.next();
		int count = 0; 
		for(int i = 0; i < s.length()-1; ++i)
		{
			if(s.charAt(i) == s.charAt(i+1))
				count++;
		}
		System.out.println(count);
	}
}
