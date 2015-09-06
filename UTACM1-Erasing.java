import java.util.*; 

public class UTACM1-Erasing
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for(int i = 0; i < t; ++i)
		{
			int count = 0; 
			for(int j = 0; j < 4; ++j)
			{
				int val = scanner.nextInt();
				if(val != (j + 1))
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
}
