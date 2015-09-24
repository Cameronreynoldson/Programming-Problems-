import java.util.*; 

//given a string and a dictionary of valid words, 
//return true if the string can be made up of 1 or multiple
//words (but all fragments of the string have to be valid words), or false
//if the entire string cannot be split up into words

public class StringMadeFromWords
{
	public boolean canBeMadeFromWords(String s, HashSet<String> set)
	{
		if(set.contains(s))
			return true; 

		for(int i = 1; i <= s.length(); ++i)
		{
			if(set.contains(s.substring(0,i)))
			{
				if(canBeMadeFromWords(s.substring(i),set))
				{
					return true;
				}
			}
		}

		return false; 
	}
}
