import java.util.*; 

public class LetterCombinations
{
	public static void main(String[] args)
	{
		int[] array = new int[25];
		ArrayList<String> l = new ArrayList<String>();
		combinations(map,numbers,l);
	}

	public static void combinations(HashMap<Integer,Character> m, int[] numbers, 
		int index, String s,  ArrayList<String> l)
	{
		if(index == numbers.length)
		{
			l.add(s);
			return; 
		}

		char c = m.get(numbers[index]);

		combinations(m,numbers,index+1,s+c,l);

		if((i < numbers.length-1) && 10*numbers[i]+numbers[i+1] <= 25)
		{
			int num = 10*numbers[i]+numbers[i+1];
			char d = m.get(num);
			combinations(m,numbers,index+2,s+d,l);
		}

	}
}
