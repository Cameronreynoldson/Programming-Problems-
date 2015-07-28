import java.util.*; 
public class EditDistance
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.next();
		String s2 = scanner.next();
		solve(s1,s2);
	}

	private static void solve(String s1, String s2)
	{
		int m = s1.length();
		int n = s2.length();

		int[][] matrix = new int[m+1][n+1];

		for(int i = 1; i <=m; ++i)
		{
			matrix[i][0] = i;
		}

		for(int i = 1; i <= n; ++i)
		{
			matrix[0][i] = i;
		}

		for(int i = 1; i <= m; ++i)
		{
			for(int j = 1; j <= n; ++j)
			{
				int difference = (s1.charAt(i) == s2.charAt(j)) ? 0: 1;
				matrix[i][j] = min(matrix[i-1][j]+1,matrix[i][j-1]+1,difference);
			}
		}

		System.out.println(matrix[m][n]);
	}

	private static int min(int a, int b, int c)
	{
		return (a < b) ? Math.min(a,c) : Math.min(b,c);
	}
}
