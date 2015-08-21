import java.util.*;

public class FindDuplicates
{
	public boolean hasDuplicates(String s)
	{
		int temp = 0; 

		for(int i = 0; i < s.length(); ++i)
		{
			int val = s.charAt(i)-'a';

			if(temp & (val << 1) > 0) 
			{
				return true;
			}

			temp |= (1 << val); 
		}

		return false; 
	}
}
