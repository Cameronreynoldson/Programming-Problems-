import java.util.*;

public class RotateMatrix
{
	public void rotate(int[][] matrix)
	{
		int row = matrix.length-1; 
		for(int i = 0; i < row; ++i,--row)
		{
			int[] temp = matrix[i];
			matrix[i] = matrix[row];
			matrix[row] = temp;
		}

		transpose(matrix); 
	}

	private void transpose(int[][] matrix)
	{
		for(int i = 0; i < matrix.length; ++i)
		{
			for(int j = i; j < matrix[0].length; ++j)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp; 
			}
		}
	}
}
