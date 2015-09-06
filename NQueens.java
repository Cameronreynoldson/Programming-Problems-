import java.util.*; 

//program to find the number of possible combinations for queens on a chessboard to be safe from each other
public class NQueens
{
	public static void main(String[] args)
	{
		int[][] board = new int[8][8];
		ArrayList<Integer[]> cols = new ArrayList<Integer[]>();
		nqueens(8,new Integer[8],0,cols);
		for(Integer[] i : cols)
		{
			for(Integer in : i)
			{
				System.out.print(in+" ");
			}
			System.out.println();
		}
	}

	//recursively check each column for each new row to see if it's valid and continue to new combinations
	public static void nqueens(int length, Integer[] cols, int row, ArrayList<Integer[]> results)
	{			
		if(row == length)
		{
			results.add(cols.clone());
		}

		else
		{
			for(int column = 0; column < length; ++column)
			{
				if(checkValid(cols,row,column))
				{
					cols[row] = column;
					nqueens(length,cols,row+1,results); 
				}
			}
		}
	}


	//check to see if a combination of (row,col) is valid given the current (row,col) pairs
	public static boolean checkValid(Integer[] cols, int row, int col)
	{
		for(int i = 0; i < row; ++i)
		{
			if(cols[i] == col)
			{
				return false; 
			}

			int colDistance = Math.abs(col-cols[i]);
			int rowDistance = row - i; 

			if(rowDistance == colDistance)
			{
				return false;
			}
		}

		return true; 
	}
}
