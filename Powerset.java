//find all subsets of a set, both iterative and recursive 
//Powerset: all subsets of a set

import java.util.*; 

public class Powerset
{
	public static void main(String[] args)
	{
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(4);
		set.add(5);
		set.add(6);
		set.add(7);
		ArrayList<ArrayList<Integer>> sets = new ArrayList<ArrayList<Integer>>();
		powerset(set,new ArrayList<Integer>(),sets,0);
		for(ArrayList<Integer> l : sets)
		{
			for(int i = 0; i < l.size(); ++i)
			{
				System.out.print(l.get(i)+" ");
			}
			System.out.println();
		}
	}

	public static void powerset(ArrayList<Integer> set, ArrayList<Integer> tempSet, ArrayList<ArrayList<Integer>> sets, int index)
	{
		if(index == set.size())
		{
			sets.add(new ArrayList<Integer>(tempSet));
			return; 
		}

		tempSet.add(set.get(index));
		powerset(set,tempSet,sets,index+1);
		tempSet.remove(tempSet.size()-1); 
		powerset(set,tempSet,sets,index+1);
	}
}
