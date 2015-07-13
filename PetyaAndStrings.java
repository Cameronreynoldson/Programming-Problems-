import java.util.*; 

public class PetyaAndStrings
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.next().toLowerCase();
		String s2 = scanner.next().toLowerCase();
		int compare = 0; 
		if(s1.compareTo(s2) > 0) compare = 1; 
		else if(s1.compareTo(s2) < 0) compare = -1; 
		else compare = 0; 
		System.out.println(compare);

	}
}
