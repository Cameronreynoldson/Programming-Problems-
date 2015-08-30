//find the diameter of a binary tree
//diameter of a binary tree: the longest distance between two nodes in a binary tree

import java.util.*;

public class BinaryTreeDiameter
{

	public static void main(String[] args)
	{
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(3);
		root.left.left.left = new Node(4);
		root.right = new Node(5);
		root.right.right = new Node(6);
		System.out.println(diameter(root));
	}
	public static int diameter(Node root)
	{
		return  height(root.right) + height(root.left);
	}



	private static int height(Node root)
	{
		if(root == null)
		{
			return 0; 
		}

		return Math.max(height(root.left),height(root.right))+1; 
	}
}

class Node
{
	Node left;
	Node right; 
	int val; 

	public Node(int v)
	{
		val = v; 
	}
}
