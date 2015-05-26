import java.util.*; 

public class SoldierAndBadges
{


	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		ArrayList<Integer> badges = new ArrayList<Integer>();
		for(int i = 0; i < n; ++i)
		{
			badges.add(scanner.nextInt());
		}
		Collections.sort(badges);
		int sum = getSum(badges); 
		solve(badges,badges.size()-1);
		int sum2 = getSum(badges);
		System.out.println(sum2-sum);
	}


	public static void solve(ArrayList<Integer> badges, int i)
	{
		if(i == 0)
		{
			return; 
		}
		else
		{
			solve(badges,i-1);
			int prev = badges.get(i-1);
			while(prev >= badges.get(i))
			{
				badges.set(i,badges.get(i)+1); 
			}
		}
	}


	public static int getSum(ArrayList<Integer> badges)
	{
		int sum = 0; 

		for(int i = 0; i < badges.size(); ++i)
		{	
			sum += badges.get(i);
		}
		return sum; 
	}
}
