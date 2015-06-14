import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CourseDilemma
{

    public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for(int i = 0; i < t; ++i)
		{
			int n = scanner.nextInt();
			int r = scanner.nextInt();

			HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>(); //store graph

			int[] degrees = new int[n];

			for(int j = 0; j < r; ++j)
			{
				int u = scanner.nextInt();
				int v = scanner.nextInt();

				degrees[u]++; 

				if(!map.containsKey(v))
				{
					map.put(v,new ArrayList<Integer>());
				}

				map.get(v).add(u);
			}

			int s = solve(map,degrees);
            
			if(s == -1)
			{
				System.out.println("Case "+(i+1)+":"+" Never Ends");
			}
			else
			{
				System.out.println("Case "+(i+1)+": "+s+" semester(s)");
			}
		}
	}

	public static int solve(HashMap<Integer,ArrayList<Integer>> map, int[] degrees)
	{
		ArrayList<Integer> sort = new ArrayList<Integer>();

		ArrayList<Integer> noPreReqs = new ArrayList<Integer>();

		for(int i = 0; i < degrees.length; ++i)
		{
			if(degrees[i] == 0)
				noPreReqs.add(i);
		}
        
        if(noPreReqs.size() <= 0) return -1; 
        int count = 1; 
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < degrees.length; ++i) set.add(i);
        int newMax = 0; 
        int visitedNodes = 0; 
		while(noPreReqs.size() > 0)
		{
            if(visitedNodes == degrees.length && sort.size()!= degrees.length) return -1; 

			int current = noPreReqs.remove(noPreReqs.size()-1);
            visitedNodes++;

			sort.add(current);

			if(map.get(current) != null)
			{
                count++;
				for(int i = 0; i < map.get(current).size(); ++i)
				{
					degrees[map.get(current).get(i)]--;
					if(degrees[map.get(current).get(i)] == 0)
						noPreReqs.add(map.get(current).get(i));
				}
			}
		}

		if(noPreReqs.size() > 0 || sort.size() > degrees.length)
			return -1; 
       
        return count; 
	}
}
