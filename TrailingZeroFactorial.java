import java.util.*; 

public class TrailingZeroFactorial
{
    public static int trailingZero(int n)
    {
        if(n < 0)
        {
            return -1; 
        }

        int count = 0; 

        for(int i = 5; n/i > 0; i*= 5)
        {
            count += n / i; 
        }

        return count; 
    }
}
