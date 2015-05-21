
import java.util.*; 

public class ABLectureRooms
{

	static HashMap<Integer,int[]> counts; 
	static boolean[] check; 

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int rooms = scanner.nextInt();
		Map<Integer,ArrayList<Integer>> m = new HashMap<Integer,ArrayList<Integer>>();
		for(int i = 0; i < rooms-1; ++i) //build the graph 
		{
			int room1 = scanner.nextInt();
			int room2 = scanner.nextInt();
			if(!m.containsKey(room1))
			{
				m.put(room1,new ArrayList<Integer>());
			}
			m.get(room1).add(room2);
			if(!m.containsKey(room2))
			{
				m.put(room2,new ArrayList<Integer>());
			}
			m.get(room2).add(room1);
		}

		counts = new HashMap<Integer, int[]>();

		check = new boolean[m.size()+1];

		int q = scanner.nextInt();

		for(int i = 0; i < q; ++i)
		{
			int room1 = scanner.nextInt();
			int room2 = scanner.nextInt();
			if(!check[room1])
			{
				getDistances(room1,m);
				check[room1] = true; 
			}
			if(!check[room2])
			{
				getDistances(room2,m);
				check[room2] = true; 
			}
			//check for equidistance 
			System.out.println(equalDistanceRooms(room1,room2,m));
		}
	}

	public static int equalDistanceRooms(int room1, int room2, Map<Integer,ArrayList<Integer>> m)
	{
		int count = 0; 
		for(int i = 1; i < m.size()+1; ++i)
		{
			if(counts.get(room1)[i] == counts.get(room2)[i] && ((i != room1 && i != room2) || (room1 == room2)))
			{
				count++; 
			}
		}
		return count; 
	}



	public static void getDistances(int room, Map<Integer, ArrayList<Integer>> m)
	{
		//bfs 
		counts.put(room,new int[m.size()+1]);
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(room); 
		while(!q.isEmpty())
		{
			int current = q.poll();
			ArrayList<Integer> adj = m.get(current); 
			for(int i = 0; i < adj.size(); ++i)
			{
				int neighbor = adj.get(i);
				if(counts.get(room)[neighbor] == 0)
				{
					counts.get(room)[neighbor] = counts.get(room)[current]+1; 
					q.add(neighbor);
				}
			}
		}
	}
}

