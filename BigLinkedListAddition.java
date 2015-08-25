//like big integer add with strings but for linkedlist

import java.util.*;

public class BigLinkedListAddition
{
	public static void main(String[] args)
	{
		Node list1 = new Node(9); 
		list1.next = new Node(9);
		list1.next.next = new Node(9);

		Node list2 = new Node(9);
		list2.next = new Node(9);

		Node l1 = addNumbers(list1,list2);
		while(l1 != null)
		{
			System.out.print(l1.val +" ");
			l1 = l1.next; 
		}
	}

	//add two numbers represented by linkedlist in reverse order
	//return the resulting number in the same reverse linkedlist fashion
	public static Node addNumbers(Node l1, Node l2)
	{
		Node head = new Node(-1); //value will be overriden  
		Node headPointer = head; 
		Node temp1 = l1;
		Node temp2 = l2; 
		int carryOver = 0;
		while(temp1 != null && temp2 != null)
		{
			int digit = temp1.val + temp2.val + carryOver; 
			if(digit >= 10)
			{
				carryOver = 1;
				digit = digit % 10;  
			}

			head.next = new Node(digit);
			head = head.next; 
			temp1 = temp1.next;
			temp2 = temp2.next; 
		}

		
		Node restOfList = (temp1 == null) ? temp2 : temp1; 

		int digit = carryOver; 

		while(restOfList != null)
		{
			digit += restOfList.val; 
			if(digit >= 10)
			{
				digit = digit % 10;
				carryOver = 1;  
			}

			head.next = new Node(digit);
			head = head.next; 
			if(restOfList.next == null)
			{
				break; 
			}
			restOfList = restOfList.next; 
		}

		if(carryOver >= 1) //last carry over just in case the last digits were too large
		{
			head.next = new Node(carryOver);
		}

		headPointer = headPointer.next; //get rid of dummy head node

		return headPointer; 
	}
}


class Node
{
	Node next;
	int val;

	public Node(int v)
	{
		val = v; 
	}
}
