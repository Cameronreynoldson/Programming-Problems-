import java.util.*;
//knapsack in nlogn using memoization
class Item
{
	int weight;
	int value;
	public Item(int w, int v)
	{
		weight = w;
		value = v;
	}
}
public class KnapsackRecursiveNlogN
{
	public static void main(String[] args)
	{
		Item a = new Item(2,4);
		Item b = new Item(1,2);
		Item c = new Item(4,5);
		Item d = new Item(3,3);
		Item e = new Item(6,20);
		Item[] bag = new Item[5];
		bag[0] = a;
		bag[1] = b;
		bag[2] = c;
		bag[3] = d;
		bag[4] = e;
		HashMap<Integer,Integer> memo = new HashMap<Integer,Integer>();
		System.out.println(knapsack(bag,bag.length-1,6,memo));
	}


	public static int knapsack(Item[] bag, int index, int weight, HashMap<Integer,Integer> memo)
	{
		if(index < 0 || weight <= 0)
		{
			return 0;
		}

		if(index == 0)
			return bag[0].value;

		if(memo.containsKey(weight))
			return memo.get(weight);

		int sum = bag[index].value;

		int nextSmallest = binarySearch(bag,weight-bag[index].weight,index-1);

		int chooseItem = knapsack(bag,nextSmallest,weight-bag[index].weight,memo);

		int dontChoose = knapsack(bag,index-1,weight,memo);

		int max = Math.max(chooseItem + sum,dontChoose);

		memo.put(weight,max);

		return max;
	}


	public static int binarySearch(Item[] bag,int weight,int index)
	{
		if(weight <= 0) return -1;

		int high = index; 
		int low = 0;
		int maxIndex = -1;
		int maxWeight = 0;
		int mid = low + (high - low) / 2; 
		while(low <= high)
		{
			int currentWeight = bag[mid].weight;

			if(currentWeight <= weight)
			{
				if(currentWeight > maxWeight && mid >= maxIndex)
				{
					maxIndex = mid;
					maxWeight = currentWeight;
				}

				low = mid+1;
			}

			else if(currentWeight > weight)
			{
				high = mid-1;
			}

			mid = low + (high - low) / 2; 
		}

		return maxIndex;
	}
}
