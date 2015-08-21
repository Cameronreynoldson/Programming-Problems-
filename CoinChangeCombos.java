import java.util.*; 
public class CoinChangeCombos 
{

	public static void main(String[] args)
	{
		int[] array = {1,2,3};
		System.out.println(getNumWays(array,3,4));
	}

	public static int getNumWays(int[] coins,int numCoins, int cents)
	{
		int[] table = new int[cents+1];
		table[0] = 1; 

		for(int i = 0; i < numCoins; ++i)
		{
			for(int j = coins[i]; j<=cents;++j)
			{
				
				table[j] += table[j-coins[i]];
			}
			System.out.println(Arrays.toString(table));
		}
		return table[cents];
	}
}
