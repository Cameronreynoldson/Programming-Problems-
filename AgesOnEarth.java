//given a sorted array of integers representing the ages
//of everyone on earth, find the number of people who have each age
//assume the age range is 0 -> 103

import java.util.*; 

public class AgesOnEarth
{
	public static void main(String[] args)
	{
		int[] ages = {1,1,1,1,1,2,2,2,2,2,50,50,61,100,103};
		int[] num = new int[104];
		findAges(ages,num);
		System.out.println(Arrays.toString(num));
	}


	public static void findAges(int[] ages, int[] num)
	{
		int lowerBound = 0; 

		for(int age = 0; age < 104 && lowerBound < ages.length; ++age)
		{
			lowerBound = binarySearch(ages,num,age,lowerBound) + 1; 
		}
	}


	public static int binarySearch(int[] ages, int[] num, int age, int lowerBound)
	{
		if(ages[lowerBound] > age)
		{
			return lowerBound - 1; 
		}

		int low = lowerBound; 

		int index = lowerBound;

		while(index < ages.length && ages[index] == age)
		{
			index *= 2; 
			if(index == 0) index += 2; 
		}

		if(index >= ages.length) index = ages.length-1;

		int high = index; 

		int lastOccurence = low; 

		int mid = low + (high-low) / 2; 

		while(low <= high)
		{
			if(ages[mid] == age)
			{
				low = mid + 1; 
				lastOccurence = mid; 
			}
			else 
			{
				high = mid - 1; 
			}

			mid = low + (high-low) / 2; 
		}

		num[age] = lastOccurence - lowerBound + 1; 

		return lastOccurence;
	}
}
