import java.util.*; 


public class LCS
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int size1 = scanner.nextInt();
		int[] a1 = new int[size1];
		for(int i = 0; i < size1; ++i)
		{
			a1[i] = scanner.nextInt();
		}
		int size2 = scanner.nextInt();
		int[] a2 = new int[size2];
		for(int i = 0; i < size2; ++i)
		{
			a2[i] = scanner.nextInt();
		}

		solve(a1,a2);
	}

	private static void solve(int[] a1, int[] a2)
	{
		int width = a1.length+1; 
		int height = a2.length+1; 

		int[][] m = new int[height][width]; 

		for(int i = 0; i < height; ++i)
		{
			for(int j = 0; j < width; ++j)
			{
				if(i == 0 || j == 0)
				{
					m[i][j] = 0; 
				}

				else if(a1[j-1] == a2[i-1])
				{
					m[i][j] = m[i-1][j-1]+1; 
				}

				else
				{
					m[i][j] = Math.max(m[i-1][j],m[i][j-1]);
				}
			}
		}

		System.out.println(m[height-1][width-1]);
	}
}
