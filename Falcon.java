import java.util.*; 

public class Falcon
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long[] array = new long[n];

    HashMap<Long,HashMap<Long,Long>> map = new HashMap<Long,HashMap<Long,Long>>();
    
		for(int i = 0; i < n; ++i) //fill in array 
		{
			long next = scanner.nextLong();
			array[i] = (long)i+1; //next;
			map.put(next,new HashMap<Long,Long>());
        }

		long[][] dp = new long[n][n]; //array to store multiplications

		for(int i = 0; i < array.length; ++i) //rows
		{
			for(int j = 0; j < array.length-i-1; ++j) //columns
			{
				if(map.get(array[j]).get(array[array.length-1-i]) == null) //if multiplication isn't stored
				{
					long val = array[j]*array[array.length-1-i]; //multiply 
					map.get(array[j]).put(array[array.length-1-i],val); //store
					dp[i][j] = array[j]*array[array.length-1-i]; //put in the matrix
				}
				else
				{
					dp[i][j] = map.get(array[j]).get(array[array.length-1-i]); //get from map and put in matrix
				}
			}
		}

		int size = n/2; 

		long max = 0; 

		for(int i = 1; i < size; ++i)
		{
			long temp = solve(dp,i,n);
			if(temp > max)
				max = temp; 
		}

		System.out.println(max);
	}

	public static long solve(long[][] m, int window, int size)
	{
		long max = 0;

		for(int i = 0; i < size; ++i)
		{
			for(int j = 0; j < size-i && size-i > j; ++j)
			{

				    long temp = 0; 
					int indexI = i; 
					int indexJ = j;
					for(int k = 0; k < window; ++k)
					{
						if(indexI >= size || indexJ >= size) break;
						temp += m[indexI][indexJ];
						indexI++;
						indexJ++;
					}

					if(temp > max)
					{
						 max = temp; 
					}
			}
		}

		return max; 
	}



	public static void print(long[][] m)
	{
		for(int i = 0; i < m.length; ++i)
		{
			for(int j = 0; j < m.length; ++j)
			{
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
	}
}
