//turn a binary search tree into a doubly linkedlist

public class BSTtoLL
{		
	public static void main(String[] args)
	{
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		Node h = new Node(-1);
		Node l = new Node(-1);
		changeToLL(root,null,null);
		Node head = h;
		System.out.println(head);
		while(head != null)
		{
			System.out.print(head.val+" ");
			head = head.right;
		}
	}


	public static void changeToLL(Node root, Node head, Node tail)
	{
		if(root == null)
		{
			return; 
		}

		if(head != null)
			System.out.println(head.val);

		changeToLL(root.left,head,tail);

		if(tail != null)
		{
			tail.right = root;
		}
		else
		{
			head = root;
		}

		root.left = tail;
		tail = root;

		changeToLL(root.right,head,tail);
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
