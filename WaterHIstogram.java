import java.util.*; 

public class WaterHistogram
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] heights = new int[size];
		for(int i = 0; i < size; ++i)
		{
			heights[i] = scanner.nextInt();
		}

		solve(heights);
	}

	private static void solve(int[] heights)
	{
		int[] maxLeft = new int[heights.length];
		int[] maxRight = new int[heights.length];

		int water = 0; 
		int max = 0; 

		for(int i = 0; i < heights.length; ++i)
		{
			max = Math.max(max,heights[i]);
			maxLeft[i] = max; 
		}

		for(int i = heights.length-1; i >= 0; --i)
		{
			max = Math.max(max,heights[i]);
			maxRight[i] = max; 
		}

		for(int i = 0; i < heights.length; ++i)
		{
			int minHeight = Math.min(maxLeft[i],maxRight[i]); 
			int area = minHeight -heights[i];
			water += area; 
		}
	}
}
