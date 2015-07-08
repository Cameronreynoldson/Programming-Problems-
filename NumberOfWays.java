import java.util.*; 


public class NumberOfWays
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in); 
		int n = scanner.nextInt();
		int[] array = new int[n];
		int[] dp = new int[n];
		int sum = 0; 
		for(int i = 0; i < n; ++i)
		{
			int next = scanner.nextInt();
			array[i] = next;
			sum += next; 
			dp[i] = sum; 
		}

		solve(n,dp);
	}


	public static void solve(int n, int[] dp)
	{
		int numWays = 0; 

		//first third
		for(int i = 0; i < n-2; ++i)
		{
			//second third
			for(int j = i+1; j < n-1; ++j)
			{
				
					if(dp[i] == (dp[j]-dp[i]) && dp[i] == (dp[n-1]-dp[j]))
					{
						numWays++;
					}
			}
		}

		System.out.println(numWays);
	}
}
