import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ConnectedCell {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];
        for(int i = 0; i < rows; ++i)
            {
            for(int j = 0; j < cols; ++j)
                {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        System.out.print(max_cell(matrix,rows,cols));
    }
    
  public static int max_cell(int[][] grid, int rows, int cols) {
        int res = 0;
        int[][] vis = new int[rows][cols];
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < cols; ++j) {
                res = Math.max(res, blob(grid, vis, i, j, rows, cols));
            }
        }
        return res;
    }

    public static int blob(int[][] g, int[][]v, int r, int c, int rows, int cols) {
        int res = 0;
        if(r < rows && r >= 0 && c < cols && c >= 0 && g[r][c] == 1 && v[r][c] == 0)
        {
            v[r][c] = 1;
            res += g[r][c];
            res += blob(g, v, r+1, c, rows, cols);
            res += blob(g, v, r-1, c, rows, cols);
            res += blob(g, v, r, c+1, rows, cols);
            res += blob(g, v, r, c-1, rows, cols);
            res += blob(g,v,r+1,c+1,rows,cols);
            res += blob(g,v,r-1,c+1,rows,cols);
            res += blob(g,v,r+1,c-1,rows,cols);
            res += blob(g,v,r-1,c-1,rows,cols);
            return res;
        }
        else 
        {
            return res;
        }
    }
 
}
