import java.util.*; 

public class Sum3

{
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int k = scanner.nextInt();
		int[] array = new int[size];
		for(int i = 0; i < size; ++i)
		{
			array[i] = scanner.nextInt();
		}

		//check if there are 3 elements that sum to k 

		System.out.println(solve(k, array));
	}

	public static boolean solve(int k, int[] array)
	{
		HashSet<Integer> set = new HashSet<Integer>();

		for(int i = 0; i < array.length; ++i)
		{
			set.add(k-array[i]);
		}

		for(int i = 0; i < array.length-1; ++i)
		{
			for(int j = i+1; j < array.length; ++j)
			{
				int difference = k - (array[i]+array[j]);
				if(set.contains(difference))
					return true; 
			}
		}

		return false;  
	}
}