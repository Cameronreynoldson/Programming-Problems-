import java.util.*; 
public class MrKitayutasColorfulGraph
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt(); 
		HashSet<Integer> colors = new HashSet<Integer>();
		Map<Integer, ArrayList<Edge>> g = new HashMap<Integer,ArrayList<Edge>>(); 
		for(int i = 0; i < m; ++i)
		{
			int u = scanner.nextInt(); 
			int v = scanner.nextInt();
			int c = scanner.nextInt();
			if(!colors.contains(c)) colors.add(c);	
			if(!g.containsKey(u))
				g.put(u, new ArrayList<Edge>());
			g.get(u).add(new Edge(v,c));
			if(!g.containsKey(v))
				g.put(v,new ArrayList<Edge>());
			g.get(v).add(new Edge(u,c));
		}

		int q = scanner.nextInt();

		for(int i = 0; i < q; ++i)
		{
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			if(g.get(u) == null || g.get(v) == null) System.out.println(0);
			else
				System.out.println(findCount(u,v,g,colors));
		}
	}


	public static int findCount(int u, int v, Map<Integer,ArrayList<Edge>> g, HashSet<Integer> colors)
	{
		int count = 0; 
		for(Integer i: colors)
		{
			if(findPath(u,v,i,g,new HashSet<Integer>()))
				count++;
		}
		return count; 
	}


	public static boolean findPath(int current, int target, int color, Map<Integer,ArrayList<Edge>> g, HashSet<Integer> visited)
	{
		if(current == target)
			return true; 
		else
		{
			visited.add(current);
			for(int i = 0; i < g.get(current).size(); ++i)
			{
				if(g.get(current).get(i).color == color && !visited.contains(g.get(current).get(i).vertex))
				{
					if(findPath(g.get(current).get(i).vertex,target,color,g,visited))
						return true; 
				}
			}
		}
		return false; 
	}


}

class Edge
{
	int vertex; 
	int color; 

	public Edge(int vertex, int color)
	{
		this.vertex = vertex; 
		this.color = color; 
	}
}
