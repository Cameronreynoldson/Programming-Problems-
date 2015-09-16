import java.util.*; 

public class IsBSTInOrder
{
	public static void main(String[] args)
	{

		int[] prev = new int[1];
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(10);
		System.out.println(isBST(prev,root,false));

	}

	public static boolean isBST(int[] prev, Node node, boolean started)
	{
		if(node == null)
		{
			return true; 
		}

		if(!isBST(prev,node.left,started))
		{
			return false; 
		}

		if(started && prev[0] >= node.value)
		{
			return false; 
		}
		else
		{
			prev[0] = node.value;
			started = true; 
		}
		
		if(!isBST(prev,node.right,started))
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
