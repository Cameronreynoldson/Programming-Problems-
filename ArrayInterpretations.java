import java.util.*; 

public class ArrayInterpretations
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] a = new int[size];
		for(int i = 0; i < size; ++i)
		{
			a[i] = scanner.nextInt();
		}
		ArrayList<String> list = new ArrayList<String>();
		findInterpretations(a,list,"", "",0);
		System.out.println(list);
	}

	public static void findInterpretations(int[] a, ArrayList<String> list, 
		String curr, String sub, int index)
	{
		if(index == a.length)
		{
			if(sub.length() > 0)
				curr += (char)(int)(Integer.valueOf(sub.toString())+96);
			if(!list.contains(curr.toString()))
				list.add(curr.toString());
			curr = "";
			return; 
		}

		sub += (a[index]);
		if(Integer.valueOf(sub.toString()) > 26)
		{
			sub = sub.substring(0,sub.length()-1);
		}
		else
		{
			findInterpretations(a,list,curr,sub,index+1);
		}

		if(sub.length() > 0)
			curr += (char)(int)(Integer.valueOf(sub.toString())+96);
		sub = "";
		findInterpretations(a,list,curr,sub,index+1);
	}
}
