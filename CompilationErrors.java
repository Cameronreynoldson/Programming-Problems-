
import java.util.*; 


public class CompilationErrors
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int errors = scanner.nextInt();
		int firstSum = 0; 
		for(int i = 0; i < errors; ++i)
		{
			firstSum += scanner.nextInt();
		}

		int secondSum = 0; 

		for(int i = 0; i < errors-1; ++i)
		{
			secondSum += scanner.nextInt();
		}

		System.out.print(firstSum-secondSum+" ");

		int thirdSum = 0; 

		for(int i = 0; i < errors-2; ++i)
		{
			thirdSum += scanner.nextInt();
		}

		System.out.print(secondSum-thirdSum);
	}
}
