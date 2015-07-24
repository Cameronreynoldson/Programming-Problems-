import java.util.*; 

public class MaxSubSquare
{

	//max sub square matrix of all 1's 

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
		solve(m);
	}

	//   1 0 0 0 1
	//   1 1 1 1 1
	//   1 1 1 1 0
	//   0 1 1 1 0
	//   0 1 0 0 1


	public static void solve(int[][] m)
	{
		int[][] aux = new int[m.length][m.length];

		//fill out first rows and columns
		for(int i = 0; i < m.length; ++i)
		{
			aux[0][i] = m[0][i];
			aux[i][0] = m[i][0];
		}

		//iterate through matrix and calculate DP matrix
		for(int i = 1; i < m.length; ++i)
		{
			for(int j = 1; j < m.length; ++j)
			{
				if(m[i][j] == 1)
				{
					int min = Math.min(aux[i-1][j],aux[i][j-1]); 
					min = Math.min(min,aux[i-1][j-1]);
					aux[i][j] = min+1; 
				}
				else
				{
					aux[i][j] = 0; 
				}
			}
		}

		//iterate through matrix again to find the max sub square

		for(int i = 0; i < m.length; ++i)
		{
			for(int j = 0; j < m.length; ++j)
			{
				if(aux[i][j] > max)
				{
					max = aux[i][j];
					maxRowBottomRight = i;
					maxColBottomRight = j; 
				}
			}
		}

		//print the area
		System.out.println(max*max);
	}
}
