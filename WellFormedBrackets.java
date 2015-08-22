import java.util.*;

public class WellFormedBrackets
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		brackets(n,0,0,"");
	}


	//import information
	//number of pairs of parentheses possible
	//number of current open parentheses that haven't been closed
	//current string


	public static void brackets(int possible, int currentlyOpen, int closed, String s)
	{
		if(s.length() == 2*possible) //we've completed a permutation
		{
			System.out.println(s);
			return;
		}

		if(currentlyOpen + closed < possible) //we can still add more open parentheses
		{
			s += "(";
			brackets(possible,currentlyOpen+1,closed,s);
			s = s.substring(0,s.length()-1);
		}

		if(currentlyOpen > 0 && closed != possible)
		{
			s += ")";
			brackets(possible,currentlyOpen-1,closed+1,s);
		}
	}
}
