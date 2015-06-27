public void reverse(Node root)
{
	Node temp = root.left; 
	root.left = root.right; 
	root.right = temp;

	if(root.right != null)
		reverse(root.right);
	if(root.left != null)
		reverse(root.left);
}