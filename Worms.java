import java.util.*; 


public class Worms
{


	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int p = scanner.nextInt();
		int[] piles = new int[p];
		int[] nums = new int[p+1];
		for(int i = 0; i < p; ++i)
		{
			piles[i] = scanner.nextInt();
			nums[i+1] = nums[i]+piles[i];
		}
		int juicy = scanner.nextInt();
		for(int i = 0; i < juicy; ++i)
		{
			int worm = scanner.nextInt();
			System.out.println(findPile(worm,nums));
		}
	}


	public static int findPile(int worm, int[] nums)
	{
		int low = 1; 
		int high = nums.length; 
		boolean found = false; 
		int mid = low+(high-low)/2; 
		while(low <= high && !found)
		{

			mid = low + (high-low)/2; 

			if(worm > nums[mid])
			{
				low = mid;
			}
			else if(worm <= nums[mid] && worm > nums[mid-1])
			{
				found = true; 
			}
			else
			{
				high = mid; 
			}
		}

		return mid; 
	}
}
