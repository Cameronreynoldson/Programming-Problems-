//check to see if a string has all unique characters
//O(n) time and O(1) space


public class UniqueCharactersBitmask
{
	public static void main(String[] args)
	{
		String s = "cameron";
		int mask = 0; 
		boolean unique = true; 
		for(int i = 0; i < s.length(); ++i)
		{
			int bit = 1 << (s.charAt(i)-'a');
			if((mask & bit) > 0)
			{
				System.out.println("DUPLICATES");
				unique = false;
				break;
			}

			mask |= bit;
		}
		if(unique)
			System.out.println("ALL UNIQUE");
	}
}
