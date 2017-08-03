package common_questions;

public class UniquePathsWithObstacles {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {  
	   int m = obstacleGrid.length;  
	   if (m == 0) return 0;  
	   int n = obstacleGrid[0].length;  
	   if (n == 0) return 0;  
	   
	   int[] row = new int[n];  
	   row[0] = 1;  
	   for (int i=0; i<m; ++i) {  
	     int total = 0;  
	     for (int j=0; j<n; ++j) {  
	       if (obstacleGrid[i][j] == 1) {  
	         row[j] = 0;  
	       } else if (j>0) {  
	         row[j] += row[j-1];  
	       }  
	       total += row[j];  
	     }  
	     if (total == 0) return 0;  
	   }  
	   
	   return row[n-1];  
	}  
}
