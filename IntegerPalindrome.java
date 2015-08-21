//check if an integer is a palindrome 

public class IntegerPalindrome
{

public static boolean checkPalindrome(int n)
	{
		int number = n;
		int remainder = 0;
		int reverse = 0;
		while(n > 0)
		{
			remainder = n%10;
			reverse = reverse*10+remainder;
			n /= 10;
		}
		
		return reverse == number;
	}
	
	}
