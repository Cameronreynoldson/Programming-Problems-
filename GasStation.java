public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int current = 0; 
        int total = 0; 
        int position = -1; 
        
        for(int i = 0; i < gas.length; ++i)
        {
            int temp = gas[i]-cost[i];
            current += temp; 
            total += temp; 
            
            if(current < 0)
            {
                current = 0; 
                position = i; 
            }
        }
        
        if(total >= 0) return (position+1)%gas.length; 
        return -1; 
    }
}
