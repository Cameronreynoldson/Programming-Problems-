import java.util.*; 

public class PalindromeAnagrams
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> s = new ArrayList<String>();
		while(scanner.hasNext())
		{
			s.add(scanner.next());
		}

		for(String str : s)
		{
			checkPal(str);
		}
	}

	public static void checkPal(String str)
	{
		if(str.length() == 1)
		{
			System.out.println("0, "+1);
			return; 
		}
		int[] count = new int[256];
		for(int i = 0; i < str.length(); ++i)
		{
			count[str.charAt(i)-'a']++;
		}	

		int odd = 0; 

		for(int i = 0; i < 256; ++i)
		{
			if(count[i] % 2 != 0)
			{
				odd++;
			}
		}

		if(odd <= 1 || str.length() == 1)
		{
			int anagrams = getNumberOfAnagrams(str);
			System.out.println("0, "+anagrams);
			return; 
		}

		for(int i = 0; i < str.length()-1; ++i)
		{
			int beginIndex = 0;
			int endIndex = str.length()-i;
			while(endIndex <= str.length())
			{
				String s = str.substring(beginIndex,endIndex);
				boolean pal = checkIfPal(s);
				if(pal)
				{
					int removed = str.length()-s.length();
					int anagrams = getNumberOfAnagrams(s);
					System.out.println(removed+", "+anagrams);
					return; 
				}

				beginIndex++;
				endIndex++;
			}
		}
	}

	public static int getNumberOfAnagrams(String s)
	{
		int[] count = new int[256];

		for(int i = 0; i < s.length(); ++i)
		{
			count[s.charAt(i)-'a']++;
		}

		int p = fact(s.length()/2);

		int initial = p;

		for(int i = 0; i < 256; ++i)
		{
			if(count[i] != 0)
			{
				int temp = count[i] / 2; 
				if(temp != 0)
				{
					initial /= fact(temp);
				}
			}
		}

		return initial; 
	}

	public static int fact(int n)
	{
		int sum = n; 

		for(int i = n-1; i >= 1; --i)
		{
			sum *= i;
		}

		return sum; 
	}


	public static ArrayList<String> permutation(String s)
	 {

	 	if(s == null)
	 	{
	 		return null;
	 	}	

	 	ArrayList<String> permutations = new ArrayList<String>();

	 	if(s.length() == 0)
	 	{
	 		permutations.add("");
	 		return permutations; 	
	 	}

	 	char c = s.charAt(0);
	 	String rest = s.substring(1);
	 	ArrayList<String> words = permutation(rest);
	 	for(String word : words)
	 	{
	 		for(int i = 0; i <= word.length(); ++i)
	 		{
	 			String temp = word.substring(0,i) + c + word.substring(i);
	 			permutations.add(temp);
	 		}
	 	}

	 	return permutations; 
	 }


	 public static boolean isPal(String s)
	 {
	 	for(int i = 0; i < s.length()/2; ++i)
	 	{
	 		if(s.charAt(i) != s.charAt(s.length()-1-i))
	 		{
	 			return false;
	 		}
	 	}
	 	return true; 
	 }


	public static boolean checkIfPal(String s)
	{
		int[] count = new int[256];
		for(int i = 0; i < s.length(); ++i)
		{
			count[s.charAt(i)-'a']++;
		}	

		int odd = 0; 

		for(int i = 0; i < 256; ++i)
		{
			if(count[i] % 2 != 0)
			{
				odd++;
			}
		}

		return odd <= 1; 
	}
}
