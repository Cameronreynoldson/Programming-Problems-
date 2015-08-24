import java.util.*; 

public class LetterCombinationsDP
{
	public static void main(String[] args)
	{
		 countCombinations(numbers);
	}


	public static int countCombinations(int[] numbers)
	{
		int[] combo = new int[numbers.length];

		combo[0] = 1; 

		for(int i = 1; i < combo.length; ++i)
		{
			combo[i] = combo[i-1]; 
			if(combo[i-1]*10 + combo[i] <= 25)
			{
				combo[i]++;
			}
		}
		
		return combo[combo.length-1];
	}
}
