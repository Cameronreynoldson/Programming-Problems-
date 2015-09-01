//check if a binary tree is a subtree of another
//binary tree (technically could work for any size tree)
//Strategy: DFS original tree until hitting the node that is the root of the 'subtree'
//we are searching for, then dfs that node and the node given for the subtree and compare
//each node

import java.util.*; 

public class CheckIfSubTree
{

	public boolean isSubtree(Node bigRoot, Node smallRoot)
	{
		Stack<Node> stack = new Stack<Node>();
		stack.push(bigRoot);
		Node temp = null; 
		while(!stack.isEmpty())
		{
			temp = stack.pop();
			if(temp == smallRoot)
			{
				break;
			}

			stack.push(temp.right);
			stack.push(temp.left);
		}

		if(temp != smallRoot) 
		{
			return false; 
		}

		Stack<Node> bigDFS = new Stack<Node>();
		Stack<Node> smallDFS = new Stack<Node>();

		bigDFS.push(temp);
		smallDFS.push(smallRoot);

		while(!bigDFS.isEmpty() && !smallDFS.isEmpty())
		{
			Node tempBig = bigDFS.pop();
			Node tempSmall = smallDFS.pop();

			if(tempBig != tempSmall)
			{
				return false; 
			}

			bigDFS.push(tempBig.right);
			bigDFS.push(tempBig.left);
			smallDFS.push(tempSmall.right);
			smallDFS.push(tempSmall.left);
		}

		if(!smallDFS.isEmpty() || !bigDFS.isEmpty())
		{
			return false; 
		}

		return true; 
	}
}

