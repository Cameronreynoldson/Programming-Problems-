//given a list of integers, find the number of pairs
//that sum to K or less


//TO-DO -> work in progress
public class KOrLess
{
	public static void main(String[] args)
	{
		int[] n = {1,2,3,4,5};
		solve(n,6);
	}

	public static void solve(int[] n,int k)
	{
		int numPairs = 0; 

		for(int i = 0; i < n; ++i)
		{
			int index = binarySearch(n[i]-k);
			if(index >= i)
				numPairs += index-1;
			else
				numPairs += index+1;
		}
	}
}
