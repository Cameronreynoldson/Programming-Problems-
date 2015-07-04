import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt(); 
		int k = scanner.nextInt(); 
		int[] array = new int[n];
		for(int i = 0; i < n; ++i)
		{
			array[i] = scanner.nextInt();
		}
		solve(array,k);
	}


	public static void solve(int[] array, int k)
	{
		int start = 1; 
		int end = k-1;
        
		while(end < array.length)
		{
			subRangeSolve(array,start,end,k);
			start++; 
			end++;
		}
	}

	public static void subRangeSolve(int[] array, int start, int end, int k)
	{   
        int prevInc = 1; 
        int prevDec = 1; 
       
		int incSubRangeSum = 0; 
		int decSubRangeSum = 0; 
        
		boolean incSwitch = false; 
		boolean decSwitch = false; 

		for(int i = start; i <= end; ++i)
		{
			if(array[i] >= array[i-1])
			{
				prevInc++;
				incSwitch = false;
			}
			else
			{
				incSubRangeSum += (prevInc*(prevInc-1)/2); 
                prevInc = 1;
				incSwitch = true;
			}
			if(array[i] <= array[i-1])
			{
				prevDec++;
				decSwitch = false; 
			}
			else
			{
				decSwitch = true; 
				decSubRangeSum += (prevDec*(prevDec-1)/2); 
                prevDec = 1; 
			}
		}
		if(!incSwitch) incSubRangeSum += ((prevInc*(prevInc-1)/2));
		if(!decSwitch) decSubRangeSum += (prevDec*(prevDec-1)/2); 
		int difference = incSubRangeSum-decSubRangeSum;
		System.out.println(difference);
	}
}
