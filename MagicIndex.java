//magic index problem: given an array of sorted integers, find if 
//there exists an element a[i] such that a[i] = i


import java.util.*; 

public class MagicIndex
{
	public static void main(String[] args)
	{
		int[] array = {1,2,3,4,5,7,8,10};
		System.out.println(magicIndex(array));
	}

	public static boolean magicIndex(int[] array)
	{
		int low = 0; 
		int high = array.length - 1; 
		int mid = low + (high-low) / 2; 
		while(low <= high)
		{
			if(array[mid] == mid)
			{
				return true; 
			}

			else if(array[mid] < mid)
			{
				high = mid - 1;  
			}

			else
			{
				low = mid + 1; 
			}

			mid = low + (high - low) / 2; 
		}

		return false; 
	}
}
