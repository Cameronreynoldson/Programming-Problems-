import java.util.*; 

public class KthNodeLinkedList
{
	public int kthNode(Node head, int k) //pass in decoy head node so we don't override the linkedlist 
	{
		if(head.next == null)
		{
			//at the tail
			return 0;
		}

		int val = kthNode(head.next);
		if(val == k-1)
		{
			System.out.println(head.val);
		}

		return 1 + val; 
	}


	public Node kthNodeIterative(Node head, int k)
	{
		Node front = head; 
		Node runner = head; 

		while(k != 0)
		{
			runner = runner.next;
			k--;
		}

		while(runner.next != null)
		{
			front = front.next;
			runner = runner.next
		}

		return front; 
	}
}
