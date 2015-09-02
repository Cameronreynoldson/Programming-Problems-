//print all permutations of a string 

import java.util.*; 

public class StringPermutations
{
	public static void main(String[] args)
	{
		String s = "cameron";
		System.out.println(permutation(s));
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
	 			System.out.println(temp);
	 			permutations.add(temp);
	 		}
	 	}

	 	return permutations; 
	 }
}
