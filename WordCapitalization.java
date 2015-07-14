import java.util.*;

public class WordCapitalization
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String word = scanner.next();
		System.out.print(Character.toUpperCase(word.charAt(0))+word.substring(1,word.length()));
	}
}
