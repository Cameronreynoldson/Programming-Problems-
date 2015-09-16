import java.util.*; 

public class IsValidBST
{
	public static void main(String[] args)
	{
		Node root = new Node(50);
		root.left = new Node(30);
		root.right = new Node(80);
		root.left.left = new Node(20);
		root.left.right = new Node(60);
		root.right.left = new Node(70);
		root.right.right = new Node(90);
		System.out.println(isValid(root));

	}

	public static boolean isValid(Node root) {
		return isValidBST(root, Integer.MIN_VALUE,
			Integer.MAX_VALUE);
	}
	private static boolean isValidBST(Node node, int MIN, int MAX) {
		if(node == null)
			return true;
		if(node.value > MIN 
			&& node.value < MAX
			&& isValidBST(node.left, MIN, Math.min(node.value,MAX))
			&& isValidBST(node.right, Math.max(node.value,MIN), MAX))
			return true;
		else 
			return false;
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
