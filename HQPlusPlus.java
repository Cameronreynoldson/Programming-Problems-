import java.util.*;

public class HQPlusPlus
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		boolean output = false;
		if(line.indexOf("Q") != -1) output = true;
		else if(line.indexOf("H") != -1) output = true; 
		else if(line.indexOf("9") != -1) output = true; 
		if(output) System.out.println("YES");
		else System.out.println("NO");
	}
}
