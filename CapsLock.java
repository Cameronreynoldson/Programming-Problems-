import java.util.*; 

public class CapsLock
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String word = scanner.next(); 
		StringBuilder sb = new StringBuilder();
		if(Character.toUpperCase(word.charAt(0)) != word.charAt(0))
		{
			sb.append(Character.toUpperCase(word.charAt(0)));
		}
		else
		{
			sb.append(Character.toLowerCase(word.charAt(0)));
		}
		for(int i = 1; i < word.length(); ++i)
		{
			if(Character.toUpperCase(word.charAt(i)) != word.charAt(i))
			{
				System.out.println(word);
				return; 
			}
			sb.append(Character.toLowerCase(word.charAt(i)));

		}

		System.out.println(sb.toString());

	}
}
