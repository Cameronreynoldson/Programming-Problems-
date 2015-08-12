public class Sieve {
    public int countPrimes(int n) {
        int sqrt = (int)Math.sqrt(n); 
        boolean[] primes = new boolean[n];
        for(int i= 0; i < primes.length; ++i) primes[i] = true; 
        for(int i = 2; i <= sqrt; ++i)
        {
            if(primes[i])
            {
                int temp = i*i; 
                int addition = 0;
                int num = temp + addition*i;
                int count = 1; 
                while(num < n)
                {
                    primes[num] = false; 
                    addition++;
                    num = temp+(addition*i);
                }   
            }
        }
        
        int primeCount = 0;
        for(int i = 2; i < primes.length; ++i)
        {
            if(primes[i])
            {
                primeCount++;
            }
        }
        
        return primeCount; 
    }
}
