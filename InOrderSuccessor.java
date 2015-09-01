//find the inorder successor of a node in a
//binary search tree given a pointer to the parent node 

public class InOrderSuccessor
{
	public Node successor(Node n)
	{
		if(n == null)
		{
			return null;
		}

		else if(n.right != null)
		{
			return minRightSubTree(n.right);
		}

		Node temp = n;

		Node p = n.parent; 

		while(p != null && p.left != temp)
		{
			temp = p; 
			p = p.parent;
		}

		return p; 
	}

	public Node minRightSubTree(Node n)
	{
		Node temp = n; 

		while(temp.left != null)
		{
			temp = temp.left;
		}

		return temp; 
	}
}
