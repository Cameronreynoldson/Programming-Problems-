import java.util.*; 

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

	public static boolean checkValid(Integer[] cols, int row, int col)
	{
		for(int i = 0; i < col; ++i)
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
