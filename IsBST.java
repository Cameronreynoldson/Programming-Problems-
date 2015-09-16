import java.util.*; 

public class IsBSTInOrder
{
	public static void main(String[] args)
	{

		int[] prev = new int[1];
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(1);
		prev[0] = Integer.MIN_VALUE;
		System.out.println(isBST(prev,root));

	}

	public static boolean isBST(int[] prev, Node node)
	{
		if(node == null)
		{
			return true; 
		}

		if(!isBST(prev,node.left))
		{
			return false; 
		}

		if(prev[0] >= node.value)
		{
			return false; 
		}
		else
		{
			prev[0] = node.value;
		}
		
		if(!isBST(prev,node.right))
		{
			return false; 
		}

		return true; 
	}	
}

class Node
{
	int value; 
	Node left; 
	Node right; 

	public Node(int v)
	{
		value = v; 
	}
}
