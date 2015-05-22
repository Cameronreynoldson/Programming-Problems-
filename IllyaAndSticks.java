
import java.util.*; 

public class IllyaAndSticks
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] sticks = new int[n];
		for(int i = 0; i < n; ++i)
		{
			sticks[i] = scanner.nextInt();
		}

		Arrays.sort(sticks);
		int[] counts = new int[sticks[sticks.length-1]+1];
		for(int i = 0; i < sticks.length; ++i)
		{
			counts[sticks[i]]++;
		}

		System.out.print(solve(counts));
	}


	public static long solve(int[] counts)
	{
		for(int i = counts.length-1; i >= 3; --i)
		{
			if((counts[i] % 2 != 0) && (counts[i-1] > 0))
			{
				counts[i]--;
				counts[i-1]++; 
			}

			if(counts[i] % 2 != 0 && counts[i-1] == 0)
			{
				counts[i]--;
			}
		}
		
		return calcArea(counts);
	}


	public static long calcArea(int[] counts)
	{
		long sum = 0; 
		int first = counts.length-1;
		int second = counts.length-1; 
		while(true)
		{
				first = second; 

				while(first >= 2 && counts[first] < 2)
				{
					first--; 
				}

				if(counts[first] < 2)
					break; 
 
				counts[first] -= 2; 

				second = first; 

				while(second >= 2 && counts[second] < 2)
				{
					second--;
				}

				if(counts[second] < 2)
					break; 

				counts[second] -= 2; 

				long firstL = first; 

				long secondL = second;
				
				sum += firstL*secondL; 
		}
		return sum; 
	}
}
