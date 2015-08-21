public class EditDistance {
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0 || word2.length() == 0) return Math.max(word1.length(),word2.length()); 
        int[][] matrix = new int[word1.length()+1][word2.length()+1]; 
        for(int i = 0; i < word1.length(); ++i)
        {
            matrix[i][0] = i;
        }
        
        for(int i = 0; i < word2.length(); ++i)
        {
            matrix[0][i] = i;
        }
        
        
        for(int i = 1; i <= word1.length(); ++i)
        {
            for(int j = 1; j <= word2.length(); ++j)
            {
                
                if(word1.charAt(i-1) == word2.charAt(j-1))
                {
                    matrix[i][j] = matrix[i-1][j-1];
                }
                else
                {
                    matrix[i][j] = min(matrix[i-1][j]+1,matrix[i][j-1]+1,matrix[i-1][j-1]+1);   
                }
            }
        }
        
        return matrix[word1.length()][word2.length()];
    }
    
    public int min(int a, int b, int c)
    {
        return (a < b) ? Math.min(a,c) : Math.min(b,c);
    }
}
