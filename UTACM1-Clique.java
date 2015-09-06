import java.util.*; 

public class UTACM1-Clique
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for(int i = 0; i < t; ++i)
		{
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			HashMap<Integer,HashSet<Integer>> map = new HashMap<Integer,HashSet<Integer>>();
			for(int j = 1; j <= n; ++j)
			{
				map.put(j, new HashSet<Integer>());
			}

			for(int j = 0; j < m; ++j)
			{
				int f1 = scanner.nextInt();
				int f2 = scanner.nextInt();

				map.get(f1).add(f2);
				map.get(f1).add(f1);
				map.get(f2).add(f2);
				map.get(f2).add(f1);
			}

			solve(n,map);
		}
	}

	public static void solve(int n, HashMap<Integer,HashSet<Integer>> map)
	{
		ArrayList<Integer> set = new ArrayList<Integer>();
		for(int i = 1; i <= n; ++i) set.add(i);
		ArrayList<ArrayList<Integer>> sets = new ArrayList<ArrayList<Integer>>();
		powerset(set, new ArrayList<Integer>(),sets,0);
		int max = 0; 
		for(ArrayList<Integer> a : sets)
		{
			int count = 0; 

			for(int i = 0; i < a.size(); ++i)
			{
				for(int j = i+1; j < a.size(); ++j)
				{
					if(!map.get(a.get(i)).contains(a.get(j)))
					{
						count++;
					}
				}
			}

			if(count <= 1)
			{
				max = Math.max(a.size(),max);
			}
		}

		System.out.println(max); 
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
