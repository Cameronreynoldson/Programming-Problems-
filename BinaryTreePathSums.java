import java.util.*; 

public class BinaryTreePathSums
{
	public void printPaths(Node root, ArrayList<Integer> path, int sum, int target)
	{
		if(sum == target)
		{
			System.out.println(path);
		}
		if(root == null)
		{
			return;
		}

		path.add(root.data);
		int tempSum = root.data+sum; 
		printPaths(root.left,path,tempSum,target);
		printPaths(root.right,path,tempSum,target);
		path.clear();
		path.add(root.data);
		printPaths(root.left,path,root.data,target);
		printPaths(root.right,path,root.data,target);
	}
}
