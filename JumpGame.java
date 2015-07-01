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
		int sum = 0; 

		for(int i = 0; i < steps.length; ++i)
		{
			if(steps[i] == 0 && sum <= i+1)
				return false; 

			sum += steps[i];
		}

		return true; 
	}


}