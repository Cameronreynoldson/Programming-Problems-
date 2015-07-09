import java.util.*; 

public class MaxPath
{

	//find the maximum path from top to bottom of a 2d matrix of integers
	//going only down, down-left and down-right
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int rows = scanner.nextInt();
		int cols = scanner.nextInt();
		int[][] matrix = new int[rows][cols];
		for(int i = 0; i < rows; ++i)
		{
			for(int j = 0; j < cols; ++j)
			{
				matrix[i][j] = scanner.nextInt();
			}
		}

		int[] dp = matrix[0];

		System.out.print(maxPathValue(matrix,dp));
 	}


 	public static int maxPathValue(int[][] matrix, int[] dp)
 	{
 		for(int i = 1; i < matrix.length; ++i)
 		{
 			for(int j = 0; j < dp.length; ++j)
 			{
 				int max1 = Integer.MIN_VALUE; 
 				int max2 = dp[j];
 				int max3 = Integer.MIN_VALUE;

 				if(j > 0)
 				{
 					max1 = dp[j-1];
 				}
 				if(j < dp.length-1)
 				{
 					max3 = dp[j+1];
 				}

 				int max = Math.max(max1,max2);

 				max = Math.max(max,max3);

 				dp[j] = matrix[i][j]+max;
 			}
 		}
 	}
}
