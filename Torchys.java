import java.util.*; 

public class Torchys
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for(int i = 0; i < t; ++i)
		{
			int friends = scanner.nextInt();
			int tab = scanner.nextInt();
			if(tab % (friends+1) == 0 || tab == 0)
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}

			for(int j = 0; j < friends; ++j) scanner.next();
		}
	}
}
