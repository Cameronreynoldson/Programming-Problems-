import java.util.*;


public class LengthDigitSum
{


	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int s = scanner.nextInt();
		if(m == 0)
		{
			if(s == 0)
				System.out.print("0 0");
			else
				System.out.print("-1 -1");
		}
		else if(s == 0 && m > 1) 
			System.out.print("-1 -1");

		else if(s == 0 && m == 1)
			System.out.print("0 0");
		
		else if(s > 9*m)
			System.out.print("-1 -1");

		else 
		{
			StringBuilder max = new StringBuilder();
			getMax(max,m,s);
			String maxNum = max.toString();
			max = max.reverse();
			getMin(max);
			String minNum = max.toString();
			System.out.print(minNum+" "+maxNum);
		}

	}

	public static void getMax(StringBuilder max, int m, int s)
	{
		int tempSum = 0; 
		int globalSum = 0; 
		while(globalSum != s)
		{
			tempSum++; 
			globalSum++; 

			if(globalSum == s)
			{
				max.append(tempSum); 

				if(max.length() < m)
				{
					while(max.length() < m)
					{
						max.append("0");
					}
				}

				return; 
			}
			else if(tempSum == 9)
			{
				max.append(9);
				tempSum = 0; 
			}
			else if(max.length() >= m && globalSum != s)
			{
				max = new StringBuilder();
				max.append("-1").append(" ").append("-1"); 
			}
		}

	}


	public static void getMin(StringBuilder min)
	{
		if(min.charAt(0) == '0')
		{
			for(int i = 0; i < min.length(); ++i)
			{
				if(min.charAt(i) != '0')
				{
					char temp = (char)(min.charAt(i)); 
					temp -= 1;
					min.setCharAt(i,temp);
					min.setCharAt(0,'1');
					return; 
				}
			}

			min = new StringBuilder();
			min.append("-1").append(" ").append("-1");
		}
	}

}
