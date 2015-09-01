//find the number of ways to get from the top left corner 
//of a matrix to the bottom right corner only going down 
//and right

import java.util.*; 

public class RobotDiagonalWays
{
	public static void main(String[] args)
	{
		int[][] matrix = new int[2][2];
		Map<Pair,Integer> m = new HashMap<Pair,Integer>();
		System.out.println(numWays(matrix,0,0,m));
	}

	public static int numWays(int[][] matrix, int row, int col,Map<Pair,Integer> m)
	{
		if(row == matrix.length-1 && col == matrix[0].length-1)
		{
			//if we reached bottom right corner
			return 1; 
		}

		Pair p = new Pair(row,col);

		if(m.containsKey(p))
		{
			return m.get(p);
		}

		int val = 0; 

		if(row < matrix.length-1)
		{
			//go in down directon
			val += numWays(matrix,row+1,col,m);
		}

		if(col < matrix[0].length-1)
		{
			//go in right direction
			val += numWays(matrix,row,col+1,m);
		}

		m.put(p,val);

		return val; 
	}
}

class Pair
{
	int row; 
	int col;

	public Pair(int r, int c)
	{
		row = r;
		col = c; 
	}

	public boolean equals(Pair p)
	{
		return (this.row == p.row) && (this.col == p.col); 
	}
}
