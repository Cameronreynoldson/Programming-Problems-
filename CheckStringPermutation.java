import java.util.*; 

public class CheckStringPermutation
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String 1 = scanner.next();
		String 2 = scanner.next();
		System.out.println(checkIfPermutation(1,2));
	}

	private static boolean checkIfPermutation(String 1, String 2)
	{
		if(1.length() != 2.length())
			return false;

		int length = 1.length();

		int[] counts1 = new int[256];

		int[] counts2 = new int[256];

		for(int i = 0; i < length; ++i)
		{
			counts1[1.charAt(i)]++; 
			counts2[1.charAt(i)]++;
		}

		for(int i = 0; i < length; ++i)
		{
			if(counts1[i] != counts2[i])
				return false; 
		}

		return true; 
	}
}
