import java.util.*; 
public class MinTrianglePath {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = 1; i < triangle.size(); ++i)
        {
            for(int j = 0; j < triangle.get(i).size(); ++j)
            {
                int value = triangle.get(i).get(j);
                int firstNum = Integer.MAX_VALUE;
                int secondNum = Integer.MAX_VALUE;
                if(j > 0)
                {
                    firstNum = triangle.get(i-1).get(j-1)+value;
                }
                if(j < triangle.get(i-1).size())
                {
                    secondNum = triangle.get(i-1).get(j)+value; 
                }
                
                triangle.get(i).set(j, Math.min(firstNum,secondNum));
            }
        }
        
        int minPathSum = Integer.MAX_VALUE; 
        for(int i = 0; i < triangle.get(triangle.size()-1).size(); ++i)
        {
            minPathSum = Math.min(minPathSum,triangle.get(triangle.size()-1).get(i));
        }
        
        return minPathSum;
    }
}
