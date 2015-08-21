import java.util.*;


public class StringAdder
{


	public static String add(ArrayList<String> list)
	{
		StringBuilder sb = new StringBuilder();

		int max = findMaxLength(list);

		boolean carriedOver = false; 

		for(int i = 0; i < max; ++i)
		{
			System.out.println("i = "+i+" sb = "+sb.toString());
			int columnSum = 0; 

			if(carriedOver)
			{
				columnSum += Character.getNumericValue(sb.charAt(sb.length()-1));
				sb.deleteCharAt(sb.length()-1);
				carriedOver = false;
			}

			for(String s: list)
			{
				int index = s.length()-1-i;

				if(index >= 0)
				{
					//we can add 
					columnSum +=  Character.getNumericValue(s.charAt(index));
				}
			}

			if(columnSum >= 10)
			{
				carriedOver = true; 
				int first = columnSum % 10; 
				sb.append(first);
				int second = columnSum / 10; 
				sb.append(second);
			}
			else
			{
				sb.append(columnSum);
			}
		}

		return sb.reverse().toString();
	}


	private static int findMaxLength(ArrayList<String> list)
	{
		int max = 0; 

		for(String s: list)
		{
			if(s.length() > max)
			{
				max = s.length();
			}
		}

		return max; 
	}
}
