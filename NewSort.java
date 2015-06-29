import java.util.*; 
public class NewSort
{

	public static void main(String[] args)
	{
		int[] array = {1,3,2,3,2,2,2,2,1,2,3,3,3};
		sort(array);
	} 


	public static void sort(int[] array)
	{
		int left = 0; 
		int right = array.length-1; 

		for(int i = 0; i < right; ++i)
		{
			if(array[i] == 1)
			{
				swap(left--,i,array);
			}

			else if(array[i] == 3)
			{
				while(array[right] == 3)
				{
					--right;
				}
				if(i < right)
				{
					swap(right--,i,array);
				}
			}
		}

		System.out.print(Arrays.toString(array));
	}

	private static void swap(int a, int b, int[] array)
	{
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp; 
	}
}