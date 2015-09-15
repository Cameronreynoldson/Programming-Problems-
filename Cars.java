import java.util.*; 

public class Cars
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for(int i = 0; i < t; ++i)
		{
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			int w = scanner.nextInt();
			final HashMap<String,Integer> types = new HashMap<String,Integer>();
			final HashMap<String,Integer> colors = new HashMap<String,Integer>();
			Car[] cars = new Car[w];
			for(int j = 0; j < u; ++j)
			{
				types.put(scanner.next(),j);
			}
			for(int j = 0; j < v; ++j)
			{
				colors.put(scanner.next(),j);
			}
			for(int j = 0; j < w; ++j)
			{
				cars[j] = new Car(scanner.next(),scanner.next());
			}

			//a-> honda
			//b-> ferrari
			//honda
			//ferrari 

			Arrays.sort(cars, new Comparator<Car>(){
				int count = 0; 
				public int compare(Car a, Car b)
				{
					if(types.get(a.type) != types.get(b.type))
					{
						return types.get(a.type).compareTo(types.get(b.type));
					}
					else
					{
						return colors.get(a.color).compareTo(colors.get(b.color));
					}
				}
			});

			for(int j = 0; j < w; ++j)
			{
				System.out.println(cars[j].type + " " + cars[j].color);
			}
		}
	}
}

class Car
{
	String type; 
	String color; 

	public Car(String t, String c)
	{
		type = t; 
		color = c; 
	}
}
