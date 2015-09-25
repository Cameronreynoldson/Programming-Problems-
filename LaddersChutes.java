import java.util.*; 

//validate the board for a game of ladders and chutes
//starting at index 0, and adding to the index every element that you reach
//at your current index, can you get to the length of the board? 
//an element 0 represents a random die roll, where your new index will be your
//current index + the die roll

public class LaddersChutes
{
	public static void main(String[] args)
	{
		int[] board = {1,7,0,0,0,0,0};
		boolean[] visited = new boolean[board.length];
		System.out.println(validate(board,0,visited));
	}

	public static boolean validate(int[] board, int index, boolean[] visited)
	{
		if(index == board.length)
		{
			return true; 
		}
		else if(index < 0 || index > board.length || visited[index])
		{
			return false; 
		}
		else
		{
			if(board[index] == 0)
			{
				for(int i = 1; i <= 6; ++i)
				{
					if(validate(board,index+i,visited))
					{
						return true; 
					}
				}
			}
			else
			{
				visited[index] = true;
				if(validate(board,board[index]+index,visited))
				{
					return true;
				}
			}
		}

		return false;
	}
}
