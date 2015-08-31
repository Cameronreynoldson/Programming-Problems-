//program to implement the tower of hanoi 
//problem for n different rings

import java.util.*; 

public class TowerOfHanoi
{
	public static void main(String[] args)
	{
		Tower t1 = new Tower();
		Tower t2 = new Tower();
		Tower t3 = new Tower();
		t1.add(3);
		t1.add(2);
		t1.add(1);
		t1.moveDisks(3,t1,t3,t2);
		while(!t3.s.isEmpty())
		{
			System.out.println(t3.s.pop());
		}
	}
}

class Tower 
{
	Stack<Integer> s; 
	int size; 

	public Tower()
	{
		s = new Stack<Integer>();
		size = 0; 
	}

	public boolean moveTopToTower(Tower origin, Tower destination)
	{
		if(!origin.s.isEmpty())
		{
			int top = origin.s.pop();
			boolean added = destination.add(top);
			if(!added)
			{
				return false;
			}
			
			return true;
		}

		return false; 
	}

	public boolean add(int val)
	{
		if(!s.isEmpty() && val >= s.peek())
		{
			System.out.println("Top value of stack is smaller than the disk you tried to add");
			return false; 
		}

		s.push(val);
		return true;
	}

	public void moveDisks(int disk, Tower origin, Tower destination, Tower buffer)
	{
		if(disk == 0) 
		{
			return; 
		}

		moveDisks(disk-1,origin,buffer,destination);
		moveTopToTower(origin,destination);
		moveDisks(disk-1,buffer,destination,origin);
	}
}
