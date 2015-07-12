import java.util.*;

public class Tram
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int min = 0; 
		int currentTrainCap = 0; 
		for(int i = 0; i < n; ++i)
		{
			min = Math.max(min,currentTrainCap);
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			currentTrainCap -= a; 
			currentTrainCap += b; 
		}

		System.out.println(min);
	}
}
