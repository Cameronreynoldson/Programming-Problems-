import java.util.*;
//hackerrank world cup competition problem
public class Bridges {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; ++i)
            {
            int c = scanner.nextInt();
            int[] cities = new int[c];
            for(int j = 0; j < c; ++j)
                {
                cities[j] = scanner.nextInt();
            }
            int count = 0;
            int[] connected = new int[c];  
            int index = 0;
            knockOut(0,cities,connected);
            for(int k = 0; k < c; ++k)
                {
                if(connected[k] != -1)
                    {
                    count++;
                    knockOut(k,cities,connected);
                }
            }
            
            System.out.println(count);
        }
    }
    
    public static void knockOut(int index, int[] cities, int[] connected)
        {
           while(connected[index] != -1)
               {
               connected[index] = -1; 
               index = cities[index]-1;
           }
    }
}
