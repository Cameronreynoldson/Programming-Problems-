//classic dynamic programming problem 
//find the minimum number of coins to sum to k given a set of denominations 

import java.util.*; 

public class MinCoinsDP
{
	public static void main(String[] args)
	{	
		int[] denominations = {0,1,2,4,5};
		int k = 10; 
		System.out.println(minCoins(denominations,k));
 	}

 	public static int minCoins(int[] denominations, int k)
 	{
 		int[][] dp = new int[denominations.length][k+1];

 		for(int i = 0; i <= k; ++i)
 		{
 			dp[0][i] = Integer.MAX_VALUE; 
 		}

 		for(int i = 1; i < denominations.length; ++i)
 		{
 			for(int j = 1; j <= k; ++j)
 			{
 				int temp = Integer.MAX_VALUE-1; 

 				if(denominations[i] <= j)
 				{
 					temp = dp[i][j-denominations[i]];
 				}

 				dp[i][j] = Math.min(dp[i-1][j],temp+1);
 				System.out.println("i = "+i+" j = "+j+" dp = "+dp[i][j]);
 			}
 		}

 		printMatrix(dp);
 		return dp[denominations.length-1][k];
 	}


 	public static void printMatrix(int[][] m)
 	{
 		for(int i = 0; i < m.length; ++i)
 		{
 			for(int j = 0; j < m[0].length; ++j)
 			{
 				System.out.print(m[i][j]+" ");
 			}
 			System.out.println();
 		}
 	} 
}
