import java.util.*; 


public class Products
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int numberOfNumbers = scanner.nextInt();
		int[] array = new int[numberOfNumbers];
		int[] productArray = new int[numberOfNumbers];

		//store numbers in array
		//then store product of all numbers in previous indices in the product array
		int factor = 1; 
		for(int i = 0; i < n; ++i)
		{
			array[i] = scanner.nextInt();
			productArray[i] = factor; 
			factor *= array[i];
		}


		//store product of all numbers in greater indices * already stored values in product array
		factor = 1; 
		for(int i = n-1; i >= 0; --i)
		{
			productArray[i] *= factor; 
			factor *= array[i];
		}

		print(productArray);
	}


	private void print(int[] array)
	{
		for(int i = 0; i < array.length; ++i)
		{
			System.out.println(array[i]);
		}
	}
}
