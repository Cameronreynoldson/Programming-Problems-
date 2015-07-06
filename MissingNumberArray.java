import java.util.*; 


public class MissingNumberArray
{

	//array of numbers from 1 to n+1, 1 number is missing, find the number
	//O(n) time O(1) space


	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int sum = 0; 
		int sumToMatch = (n+1) + (n+1)*(n)/2;  
		for(int i = 0; i < n; ++i)
		{	
			sum += scanner.nextInt();
		}

		System.out.println(sumToMatch-sum);
	}
}
