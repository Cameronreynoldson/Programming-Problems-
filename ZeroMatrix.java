import java.util.*;  

public class ZeroMatrix
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int rows = scanner.nextInt();
		int cols = scanner.nextInt();
		int[][] m = new int[rows][cols];
		for(int row = 0; row < rows; ++row)
		{
			for(int col = 0; col < cols; ++col)
			{
				m[row][col] = scanner.nextInt();
			}
		}

		solve(m);
	}

	public static void solve(int[][] m)
	{
		HashSet<Integer> rows = new HashSet<Integer>();
		HashSet<Integer> cols = new HashSet<Integer>();

		for(int i = 0; i < m.length; ++i)
		{
			for(int j = 0; j < m[0].length; ++j)
			{
				if(m[i][j] == 0)
				{
					rows.add(i);
					cols.add(j);
				}
			}
		}

		for(Integer row: rows)
		{
			for(int i = 0; i < m[0].length; ++i)
			{
				m[row][i] = 0; 
			}
		}

		for(Integer col: cols)
		{
			for(int i = 0; i < m.length; ++i)
			{
				m[i][col] = 0; 
			}
		}
	}
}
