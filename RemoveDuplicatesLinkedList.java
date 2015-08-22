import java.util.*; 


// 1->2->1->3->4->2->null

public class RemoveDuplicatesLinkedList
{
	public void removeLinearMemory(Node n)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(head.val);
		Node head = n; 
		Node temp = head;
		head = head.next; 
		while(head != null)
		{
			if(set.contains(head.val))
			{
				remove(temp);
			}
			else
			{
				set.add(head.val);
			}
			temp = head; 
			head = head.next; 
		}
	}

	private void remove(Node node)
	{
		node.next = node.next.next; 
	}

	public void removeConstantMemory(Node n)
	{
		Node current = n; 
		while(current != null)
		{
			Node runner = n;
			while(runner.next != null)
			{
				if(runner.next.val == current.val)
				{
					runner.next = runner.next.next; 
				}
				else
				{
					runner = runner.next; 
				}
			}
		}
	}
}

class Node
{
	int val;
	Node next; 

	public Node(int v)
	{
		val = v; 
	}
}
