import java.util.*; 

//1 2 3 4 5 
//6 7 8 9 7
//2 1 2 4 5 
//2 5 6 7 8
//2 3 5 7 3

public class MatrixRotation
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] m = new int[n][n];
		for(int i = 0; i < n; ++i)
		{
			for(int j = 0; j < n; ++j)
			{
				m[i][j] = scanner.nextInt();
			}
		}

		int[][] rotated = rotate(m,n);
	}

	private static int[][] rotate(int[][] m, int n)
	{
		int layers = n/2; 

		for(int = layer; i < layers; ++layers)
		{
			int start = layer; 
			int end = n - 1 - layer;

			for(int i = start; i < end; ++i)
			{
				int offset = i - start; 
				int top = m[start][i];

				m[start][i] = m[end-offset][start];
				m[end-offset][start] = m[end][end-offset];
				m[end][end-offset] = m[i][end];
				m[i][end] = top;
			} 	
		}

		return m; 
	}
}
