import java.util.*; 

public class UTACM1-Primes
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		HashSet<Integer> s = calcPrimes();
		for(int i = 0; i < t; ++i)
		{
			String num = scanner.next();
			solve(num,s);
		}
	}

	public static void solve(String num, HashSet<Integer> s)
	{
		for(int i = 0; i < num.length(); ++i)
		{
			for(int j = i+1; j <= num.length(); ++j)
			{
				int n = Integer.parseInt(num.substring(i,j));
				if(s.contains(n))
				{
					System.out.println("YES");
					return;
				}
			}
		}
		System.out.println("NO");
	}

	public static HashSet<Integer> calcPrimes()
	{
		int sqrt = (int)Math.sqrt(1000);
		boolean[] primes = new boolean[1000];
		for(int i = 0; i < primes.length; ++i)primes[i] = true; 
		for(int i = 2; i <= sqrt; ++i)
		{
			if(primes[i])
			{
				int temp = i*i;
				int addition = 0; 
				int num = temp + addition*i;
				while(num < 1000)
				{
					primes[num] = false;
					addition++;
					num = temp+addition*i;
				}
			}
		}

		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 2; i < primes.length; ++i)
		{
			if(primes[i])
				set.add(i);
		}
		return set; 
	}
}
