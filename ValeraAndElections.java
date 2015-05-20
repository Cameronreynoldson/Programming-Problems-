
import java.util.*; 

public class ValeraAndElections
{

	static int[] arr = new int[300000]; 
	static int[] DP = new int[300000]; 
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for(int i = 0;  i <= 300000; ++i) adj.add(new ArrayList<Integer>());
 		for(int i = 0; i < n-1; ++i)
		{
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			int p = scanner.nextInt();
			if(p == 2)
			{
				arr[u] = 1;
				arr[v] = 1;
			}
			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		dfs(1,-1); // build up DP array

		int count = 0; 
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i <= n; ++i)
		{
			if(DP[i] == 1 && arr[i] == 1)
			{
				count++; 
				sb.append(i);
				sb.append(" ");
			}
		}
		System.out.print(count+" "+sb.toString());
	}

	public static void dfs(int current, int parent)
	{
		DP[current] = arr[current];
		ArrayList<Integer> adjList = adj.get(current);
		for(int i = 0; i < adjList.size(); ++i)
		{
			int n = adjList.get(i);

			if(n != parent)
			{
				dfs(n,current);
				DP[current] += DP[n];
			}
		}
	}
}
