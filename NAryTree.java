import java.util.*; 



public class NAryTree
{

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.addChild(new TreeNode(2));
		root.addChild(new TreeNode(3));
		for(TreeNode child: root.children)
		{
			child.addChild(new TreeNode(4));
		}

		printTree(root);
	}



	//print all of the levels in an n-ary tree, each level separated by a line break
	public static void printTree(TreeNode root)
	{
		Queue<TreeNode> q = new LinkedList<TreeNode>(); 

		int currentCounter = 0; //counter to keep track of the current node in the current level, check against thisLevelCounter
		
		int nextLevelCounter = 0; //counter to count the number of levels that the NEXT level should have

		int thisLevelCounter = 1; //number of nodes that the CURRENT level should have

		q.add(root);

		while(!q.isEmpty())
		{
			if(currentCounter == thisLevelCounter)
			{
				thisLevelCounter = nextLevelCounter; 
				nextLevelCounter = 0; 
				currentCounter = 0;
				System.out.println();
			}

			TreeNode temp = q.poll();

			currentCounter++;

			System.out.print(temp.val+" ");

			for(TreeNode child: temp.children)
			{
				q.add(child);
				nextLevelCounter++;
			}
		}

	}
}


//TreeNode structure
class TreeNode
{
	int val; 
	ArrayList<TreeNode> children;

	public TreeNode(int v)
	{
		val = v;
		children = new ArrayList<TreeNode>();
	}

	public void addChild(TreeNode c)
	{
		this.children.add(c);
	}
}
