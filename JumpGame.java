import java.util.*; 


public class JumpGame
{

//1 2 0 0 2 3 4 1 5 0
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] steps = new int[size];
		for(int i = 0; i < size; ++i)
		{
			steps[i] = scanner.nextInt();
		}

		System.out.println(solve(steps));
	}

	public static boolean solve(int[] steps)
	{
		int max = 0;  

		for(int i = 0; i < steps.length; ++i)
		{
			max = Math.max(max,steps[i]+i);
			if(i >= max)
				return false;

		}

		return true; 
	}


}