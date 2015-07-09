import java.util.*; 



public class LargestBlob
{	


	//find the largest contiguous set of 1's in a binary matrix, aka the largest blob
	//to do this we can either use BFS/DFS or disjoint sets, here we will use BFS/DFS

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

		boolean[][] visited = new boolean[matrix.length][matrix[0].length];

		int max = 0; 

		for(int i = 0; i < rows; ++i)
		{
			for(int j = 0; j < cols; ++j)
			{
				if(matrix[i][j] == 1 && !visited[i][j])
				{	
					visited[i][j] = true; 
					max = Math.max(max,solve(matrix,i,j));
				}
			}
		}

		solve(matrix,visited,0,0);
 	}


 	public static int solve(int[][] matrix, int[][] visited, int row, int col) 
 	{
 		int sum = 1;

 		for(int i = -1; i <= 1; ++i)
 		{
 			for(int j = -1; j <= 1; ++j)
 			{
 				if(row+i >= 0 && row+i < matrix.length && col+j >= 0 && col+j < matrix[0].length)
 				{
 					if(matrix[i+row][j+col] == 1)
 					{
 						sum += solve(matrix,visited,row+i,col+j);
 					}
 				}
 			}
 		}

 		return sum; 
 	}

}
