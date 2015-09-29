
//remove all vowels in a string
public class RemoveVowels
{
	public String removeVowels(String s, HashSet<Character> vowels)
	{
		StringBuilder sb = new StringBuilder(); 
		for(int i = 0; i < s.length(); ++i)
		{
			if(!vowels.contains(s.charAt(i)))
			{
				sb.append(s.charAt(i));
			}
		}

		return sb.toString();
	}

	public void removeVowels(char[] s, HashSet<Character> vowels)
	{
		for(int i = 0; i < s.length; ++i)
		{
			if(vowels.contains(s[i]))
			{
				pushBack(s,i);
			}
		}
	}

	private void pushBack(char[] s, int index)
	{
		for(int i = index; i < s.length-1; ++i)
		{
			s[i] = s[i+1];
		}
	}
}
