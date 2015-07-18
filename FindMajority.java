import java.util.*; 

public class FindMajority 
{
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

	private static void solve(int[] array)
	{
		int indexOfMajority = 0; 
		int countOfElement = 1; 

		for(int i = 1; i < array.length; ++i)
		{
			if(array[indexOfMajority] == array[i])
			{
				countOfElement++; 
			}
			else
			{
				countOfElement--; 
				if(countOfElement <= 0)
				{
					indexOfMajority = i; 
				}
			}
		}

		int element = array[indexOfMajority];

		if(checkIfMajority(element,array))
		{
			System.out.println("Majority = "+element);
		}
		else
		{
			System.out.println("No majority");
		}
	}

	private static boolean checkIfMajority(int element, int[] array)
	{
		int countCheck = 0; 
		for(int i = 0; i < array.length; ++i)
		{
			if(array[i] == element)
			{
				countCheck++;
			}
		}

		if(countCheck > array.length/2)
			return true; 
		else
			return false;
	}
}
