import java.util.*; 


public class SubsetSum
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int target = scanner.nextInt();
		int size = scanner.nextInt();
		int[] set = new int[size];
		for(int i = 0; i < size; ++i)
		{
			set[i] = scanner.nextInt();
		}
	}

	private static boolean solve(int[] set, int target)
	{
		boolean[][] dp = new boolean[set.length][target+1];

		for(int i = 1; i <= target; ++i)
		{
			if(i == set[0])
				dp[0][i] = true;
		}

		for(int i = 0; i < set.length; ++i)
		{
			dp[i][0] = true; 
		}

		for(int i = 1; i < set.length; ++i)
		{
			for(int j = 1; j <= target; ++j)
			{
				if(j >= set[i])
				{
					if(dp[i-1][j-set[i]])
					{
						dp[i][j] = true; 
					}
					else
					{
						dp[i][j] = dp[i-1][j];
					}
				}
			}
		}
		return dp[set.length-1][target];
	}
}
