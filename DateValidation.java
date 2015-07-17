import java.util.*; 

public class DateValidation
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt(); 
		int z = scanner.nextInt();

		Map<Integer,Integer> validDates = new HashMap<Integer,Integer>();

		addDates(validDates);
		String[] dates = new String[6]; 
		dates[0] = solve(x,y,z,validDates);
		dates[1] = solve(z,x,y,validDates);
		dates[2] = solve(y,z,x,validDates);
		dates[3] = solve(y,x,z,validDates);
		dates[4] = solve(z,y,x,validDates);
		dates[5] = solve(x,z,y,validDates);

		int validStringIndex = -1; 
		boolean moreThanOneDate = false; 
		for(int i = 0; i < 6; ++i)
		{
			if(!dates[i].equals("") && validStringIndex != -1)
			{
				moreThanOneDate = true; 
			}

			else if(!dates[i].equals(""))
			{
				validStringIndex = i; 
			}
		}

		if(moreThanOneDate) System.out.println("Ambiguous");
		else System.out.println(dates[validStringIndex]);
	}

	private static void addDates(Map<Integer,Integer> validDates)
	{
		validDates.put(1,31);
		validDates.put(2,28);
		validDates.put(3,31);
		validDates.put(4,30);
		validDates.put(5,31);
		validDates.put(6,30);
		validDates.put(7,31);
		validDates.put(8,31);
		validDates.put(9,30);
		validDates.put(10,31);
		validDates.put(11,30);
		validDates.put(12,31); 
	}

	private static String solve(int x, int y, int z, Map<Integer,Integer> validDates)
	{
		int possibleDates = 0; 
		StringBuilder date = new StringBuilder();
		if(validDates.containsKey(x) && validDates.get(x) >= y)
		{
			if(x <10)
			{
				date.append("0");
			}
				date.append(x+"/");

			if(y < 10)
			{
				date.append("0");
			}
				date.append(y+"/");

			if(z < 10)
			{
				date.append("0");
			}
			date.append(z);

		}
		return date.toString();
	}
}
