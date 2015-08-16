public class MaxPathDownRight {
    public int minPathSum(int[][] grid) {
        for(int i = 0; i < grid.length; ++i)
        {
            for(int j = 0; j < grid[0].length; ++j)
            {
                int num_1 = Integer.MAX_VALUE; 
                int num_2 = Integer.MAX_VALUE; 
                boolean valid = false; 
                
                if(i-1 >= 0 && i < grid.length)
                {
                    num_1 = grid[i-1][j];
                    valid = true;
                }
                
                if(j-1 >= 0 && j < grid[0].length)
                {
                    num_2 = grid[i][j-1];
                    valid = true; 
                }
                
                grid[i][j] = (valid) ? Math.min(num_1,num_2) + grid[i][j] : grid[i][j];
            }
        }
        
        return grid[grid.length-1][grid[0].length-1];
    }
}
