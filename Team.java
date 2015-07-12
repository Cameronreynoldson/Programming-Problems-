import java.util.*; 

public class Teams
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int problems = 0; 
		for(int i = 0; i < n; ++i)
		{
			int sum = scanner.nextInt()+scanner.nextInt()+scanner.nextInt();
			if(sum >= 2)
				problems++;
		}
		System.out.println(problems);
	}
}
