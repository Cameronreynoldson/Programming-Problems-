//find the number of ways up to k values sum to n (can have duplicates)
import java.util.*; 

public class UTACM1-Stairs
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for(int i = 0; i < t; ++i)
		{
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			ArrayList<Integer> l = new ArrayList<Integer>();
			for(int j = 0; j < k; ++j) l.add(scanner.nextInt());
			int num = solve(n,l);
			System.out.println(num);
		}
	}

	public static int solve(int n, ArrayList<Integer> k)	
	{
		if(n < 0)
		{
			return 0;
		}

		if(n == 0)
		{
			return 1; 
		}

		int count = 0; 

		for(int i = 0; i < k.size(); ++i)
		{
			count += solve(n-k.get(i),k);
		}

		return count;
	}
}
