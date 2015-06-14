//merge two unsorted lists into one and sort them
//binary search insertion 

import java.util.*; 

public class TwoListMerge
{

	public ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2)
	{
		ArrayList<Integer> newList = new ArrayList<Integer>();

		for(int i = 0; i < list1.size(); ++i)
		{
			binarySearchInsert(newList,list1.get(i));
		}

		for(int i = 0; i < list2.size(); ++i)
		{
			binarySearchInsert(newList,list2.get(i));
		}

		return newList; 
	}

	private void binarySearchInsert(ArrayList<Integer> list, int number)
	{
		int low = 0; 
		int high = list.size();
		boolean inserted = false; 
		while(low <= high && !inserted)
		{
			int mid = low + (high-low)/2; 
			if(list.get(mid) > number)
			{
				high = mid; 
			}
			else if(list.get(mid) < number)
			{
				low = mid;
			}
			else
			{
				list.add(mid,number);
				break;
			}
		}
	}
}
