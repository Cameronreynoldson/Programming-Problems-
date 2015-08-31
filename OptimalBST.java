//write a program to create a balanced 
//binary search tree given an array of sorted (ascending) integers

import java.util.*; 

public class OptimalBST
{
	public Node createBalancedBST(int[] array)
	{
		return createBalancedBST(int[] array,0,array.length-1);
	}


	private Node createBalancedBST(int[] array, int low, int high)
	{
		if(high < low)
		{
			return null;
		}

		int mid = low + (high-low) / 2; 
		Node n = new Node(array[mid]);
		n.left = createBalancedBST(array,low,mid-1);
		n.right = createBalancedBST(array,mid+1,high);
		return n;
	}
}

class Node
{
	int val; 
	Node left; 
	Node right; 

	public Node(int v)
	{
		val = v; 
	}
}
