import java.util.*; 

public class MaxAndMin
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int array = new int[size];
		for(int i = 0; i < size; ++i)
		{
			array[i] = scanner.nextInt();
		}

		solve(array);
	}

	public static void solve(int[] array)
	{
		int max = array[0];
		int min = array[0];

		for(int i = 1; i < array.length; ++i)
		{
			if(array[i] > max)
				max = array[i];
			if(array[i] < min)
				min = array[i];
		}

		System.out.println("Max = "+max);
		System.out.println("Min = "+min);
	}
}