import java.util.*; 

public class BitPlusPlus
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int x = 0; 
		String add = "++";
		String subtract = "--";
		for(int i = 0; i < n; ++i)
		{
			String expression = scanner.next();
			if(expression.indexOf(add) != -1)
				x++;
			if(expression.indexOf(subtract) != -1)
				x--;
		}
		System.out.println(x);
	}
}
