import java.util.*;

public class IsBST
{

	public boolean checkIfBST(Node node)
	{
		if(node.left.data.compareTo(node.data) >= 0 || node.right.data.compareTo(node.data) <= 0)
			return false; 
		else
		{
			if(!checkIfBST(node.right))
				return false; 
			if(!checkIfBST(node.left))
				return false;
		}

		return true; 
	}
}
