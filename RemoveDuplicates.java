import java.util.*; 

public class RemoveDuplicates
{
	//if space is allowed
	public void removeDups(Node n)
	{
		HashSet<Node> set = new HashSet<Node>();
		Node prev = null; 
		while(n != null)
		{
			if(set.contains(n))
			{
				previous.next = n.next; 
			}
			else
			{
				set.add(n);
				prev = n; 
			}
		}

		n = n.next; 
	}


	//if space is not allowed, O(n^2)
	public void removeDupsNoSpace(Node n)
	{
		if(n == null)
			return; 
		Node current = n; 
		while(current != null)
		{
			Node runner = current; 
			while(runner.next != null)
			{
				if(runner.next.equals(current))
				{
					runner.next = runner.next.next; 
				}
				else
				{
					runner = runner.next; 
				}
			}
			current = current.next; 
		}
	}
}
