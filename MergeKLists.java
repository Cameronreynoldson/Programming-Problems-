//merge K sorted LinkedLists

import java.util.*; 

public class MergeKLists
{
	public Node merge(ArrayList<Node> lists)
	{
		Node head = new Node(0);
		Node temp = head; 

		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator(){
			public int compare(Node a, Node b)
			{
				return a.val - b.val;
			}
		});

		for(Node n : lists)
		{
			pq.add(n);
		}


		while(!pq.isEmpty())
		{
			Node current = pq.poll();

			if(current.next != null)
				pq.add(current.next);

			temp.next = current;

			temp = temp.next; 
		}

		return head.next; 
	}
}
