package common_questions;

public class UniquePaths {
	// Time O(m*n), space O(min(m,n))
	// 
	public int uniquePathsUsingDP(int m, int n) {  
	   if (m == 0 || n == 0) return 0;  
	   int x = Math.max(m, n), y = Math.min(m, n);  
	   int[] row = new int[y];  
	   
	   row[0] = 1;  
	   
	   // fill up the table  
	   for (int i=0; i<x; ++i) {  
	     for (int j=1; j<y; ++j) {  
	       row[j] += row[j-1];  
	     }  
	   }  
	   
	   return row[y-1];  
	}  
	// Time O(min(m,n)) and space O(1)
	public int uniquePathsUsingMath(int m, int n) {  
		   if (m == 0 || n == 0) return 0;  
		   
		   int x = Math.min(m, n), y = Math.max(m, n);  
		   double count = 1;  
		   for (int i=1; i<x; ++i) {  
		     count *= (y + i - 1);  
		     count /= i;  
		   }  
		   
		   return (int)count;  
		 }  
}
