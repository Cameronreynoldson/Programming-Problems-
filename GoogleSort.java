import java.util.*; 


public class GoogleSort
{

	//given an unsorted array, arrange them such that a < b > c < d > e.....
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] array = new int[size];
		for(int i = 0; i < size; ++i)
		{
			array[i] = scanner.nextInt();
		}

		solve(array);
	}

	public static void solve(int[] array)
	{
		Arrays.sort(array);
		for(int i = 2; i < array.length; i += 2)
		{
			int temp = array[i];
			array[i] = array[i-1];
			array[i-1] = temp; 
		}

		System.out.println(Arrays.toString(array));
	}

}

// 1 2 3 4 5
// 1 3 2 5 4
