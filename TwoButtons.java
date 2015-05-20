
import java.util.*; 

public class TwoButtons
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		System.out.print(bfs(n,m));
	}

	public static int bfs(int n, int m)
	{
		int count = 0; 
		int max = Math.max(m,n);
		int[] countHolder = new int[2*max+1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		countHolder[n] = 0;
		while(!q.isEmpty())
		{
				int current = q.poll();

				if(current == m)
				{
					return countHolder[current];
				}
				if(current < m)
				{
					if(countHolder[current*2] == 0)
					{
						q.add(current*2);
						countHolder[current*2] = countHolder[current]+1;
					}
				}

				if(current > 0)
				{
					if(countHolder[current-1] == 0)
					{
						q.add(current-1);
						countHolder[current-1] = countHolder[current]+1; 
					}
				}
		}
		return countHolder[m];
	}
}
