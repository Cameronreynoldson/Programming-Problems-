import java.util.*; 


public class Taxi
{


	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int g = scanner.nextInt();
		int[] groups = new int[g];
		for(int i = 0; i < g; ++i)
		{
			groups[i] = scanner.nextInt();
		}
		Arrays.sort(groups);
		int index1 = 0; 
		int index2 = g-1; 
		int cars = 0; 
		while(index1 <= index2)
		{
			int temp = groups[index2];
			while(index1 <= index2 && temp + groups[index1] <= 4)
			{
				temp += groups[index1];
				index1 += 1; 
			}
			index2 -= 1;
			cars += 1; 
		}
		System.out.println(cars);
	}
		
}
