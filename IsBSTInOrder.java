public static boolean isBST( Node node, int[] prev, boolean[] started)
	{
		if(node == null)
		{
			return true;
		}
		
		if(!isBST(node.left, prev, started))
		{
			return false;
		}
		
		if(!started[0])
		{
			started[0] = true;
		}
		else if (node.value <= prev[0])
		{
			return false;
		}

		prev[0] = node.value;
		return isBST(node.right, prev, started));
	}	
}
