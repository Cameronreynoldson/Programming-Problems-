//find the median of two sorted arrays both of size n
import java.util.*; 

public class MedianTwoArrays
{
	public static void main(String[] args)
	{
		int[] a1 = {1,2,3,4,5,6,7,8};
		int[] a2 = {-2,-1,0,1,2,3,4,8};
	}

	public static double findMedian(int[] a1, int[] a2)
	{
		//fill in
	}

	public static int median(int[] a1, int[] a2, int k, int boundLow1, int boundHigh1,
		int boundLow2, int boundHigh2)
	{
		int a1Length = boundHigh1 - boundLow1 + 1;

		int a2Length = boundHigh2 - boundLow2 + 1;

		if(a1Length == 0)
		{
			return a2[boundLow2+k];
		}

		if(a2Length == 0)
		{
			return a1[boundLow1+k];
		}

		if(k == 0)
		{
			return Math.min(a1[boundLow1],a2[boundLow2]);
		}

		int a1Mid = boundLow1 + (boundHigh1 - boundLow1)/2; 

		int a2Mid = boundLow2 + (boundHigh2 - boundLow2)/2; 

		if(a1[a1Mid] > a2[a2Mid])
		{
			k -= (a2Mid - boundLow2 + 1);
			boundHigh1 = a1Mid; 
			boundLow2 = a2Mid+1;
		}
		else
		{
			k -= (a1Mid - boundLow1 + 1);
			boundHigh2 = a2Mid; 
			boundLow1 = a1Mid + 1; 
		}

		return median(a1,a2,k,boundLow1,boundHigh1,boundLow2,boundHigh2);
	}
}
