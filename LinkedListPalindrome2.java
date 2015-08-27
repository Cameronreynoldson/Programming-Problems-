//check to see if a singly linkedlist is a palindrome

import java.util.*; 

public class LinkedListPalindrome2
{
	public static void main(String[] args)
	{
		 Node head = new Node(3);
		 head.next = new Node(4);
		 head.next.next = new Node(5);
		 head.next.next.next = new Node(2);
		 head.next.next.next.next = new Node(3);
		 System.out.println(isPalindrome(head));
	}
	
	public static boolean isPalindromeSecond(Node head)
	{
		Node temp1 = head;
		Node temp2 = head; 
		return isPalindromeRecursive(temp1,temp2) != null;
	}

	private static Node isPalindromeRecursive(Node head, Node tail)
	{
		if(tail.next == null)
		{
			if(tail.val == head.val)
			{
				return head.next; 
			}

			return null;
		}

		Node compareTail = isPalindromeRecursive(head,tail.next);

		if(compareTail.val == tail.val)
		{
			if(compareTail.next == null)
			{
				return compareTail; 
			}

			return compareTail.next;  
		}

		return null;
	}

//3 -> 2 -> 2 <- 2 <- 3
	public static boolean isPalindrome(Node head)
	{
		Node tempHead = head; //temporary pointer for head node, going to use to iterate later 
		
		Node slow = head;

		Node runner = head; 

		while(runner.next != null)
		{
			slow = slow.next; 
			runner = runner.next.next; 
		}

		//reverse latter half of linkedlist with 'slow' node
		Node prev = null;
		
		while(slow != null)
		{
			Node tempNext = slow.next;
			slow.next = prev;
			prev = slow; 
			slow = tempNext;
		}

		Node tail = prev; //pointer to the tail node since 'slow' is now null

		while(tail != null)
		{
			if(tail.val != tempHead.val)
			{
				return false;
			}
			tail = tail.next; 
			tempHead = tempHead.next; 
		}

		return true;
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
