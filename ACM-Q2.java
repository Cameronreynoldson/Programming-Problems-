import java.util.*;

public class Q2
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for(int i = 0; i < t; ++i)
		{
			String s = scanner.next(); 
			int sum = 0; 
			ArrayList<String> l = new ArrayList<String>(); 
			boolean b = true; 
			for(int j = 0; j < s.length(); ++j)
			{
				if(s.charAt(j) != '-')
				{
					//System.out.print(Integer.parseInt(s.charAt(j)+"")+" ");
					int x = Integer.parseInt(s.charAt(j)+"");
					if(b)
						l.add((x*2)+"");
					else
						l.add(x+"");
					b = !b; 
				}
			}

			for(int j = 0; j < l.size(); ++j)
			{
				for(int k = 0; k < l.get(j).length(); ++k)
				{
					int x = Integer.parseInt(l.get(j).charAt(k)+"");
					sum += x; 
				}
			}

			if(sum % 10 == 0)
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}

		}


	}
}
