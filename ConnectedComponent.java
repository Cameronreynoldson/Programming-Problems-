import java.util.*; 


public class ConnectedComponent
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for(int i = 0; i < t; ++i)
		{
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			int w = scanner.nextInt();
			HashMap<String,HashSet<String>> graph = new HashMap<String,HashSet<String>>();
			for(int j = 0; j < u; ++j)
			{
				String a = scanner.next();
				String b = scanner.next();
				if(!graph.containsKey(a))
				{
					graph.put(a,new HashSet<String>());
				}

				if(!graph.containsKey(b))
				{
					graph.put(b, new HashSet<String>());
				}

				graph.get(a).add(b);
				graph.get(b).add(a);

			}

			HashSet<String> offline = new HashSet<String>();
			for(int j = 0; j < v; ++j)
			{
				offline.add(scanner.next());
			}
			ArrayList<String> posting = new ArrayList<String>();
			for(int j = 0; j < w; ++j)
			{
				posting.add(scanner.next());
			}

			solve(graph,offline,posting);
		}
	}


	public static void solve(HashMap<String,HashSet<String>> g, HashSet<String> off,
	 ArrayList<String> post)
	{
		for(String s: post)
		{
			HashSet<String> visited = new HashSet<String>();
			visited.add(s);
			ArrayList<String> connections = new ArrayList<String>(); 
			dfs(s,g,off,connections,visited);
			Collections.sort(connections);
			for(int i = 0; i < connections.size()-1; ++i)
			{
				System.out.print(connections.get(i)+" ");
			}
			if(connections.size() == 0)
				System.out.println("NONE");
			else
				System.out.println(connections.get(connections.size()-1));
		}
	}

	public static void dfs(String start, HashMap<String,HashSet<String>> g, 
		HashSet<String> off, ArrayList<String> c, HashSet<String> visited)
	{
		for(String adj : g.get(start))
		{
			if(!off.contains(adj) && !visited.contains(adj))
			{
				c.add(adj);
				visited.add(adj);
				dfs(adj,g,off,c,visited);
			}
		}
	}
}
