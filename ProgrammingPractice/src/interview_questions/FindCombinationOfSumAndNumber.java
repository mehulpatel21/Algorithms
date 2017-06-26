package interview_questions;

import java.util.ArrayList;

public class FindCombinationOfSumAndNumber {

	public static void main(String[] args) {
	  int n = 16;
	  int k = 2;
	  combSum(n, k, new ArrayList<Integer>(), 0);
	}
	
	public static void combSum(int n, int k, ArrayList<Integer> list, int start) {
		  if (list.size() == k && n != 0) return;
		  if (list.size() == k && n == 0) {
		    System.out.println(list);
		    return;
		  }
		  
		  for (int i = start; i <= n; i++) {
		    list.add(i);
		    combSum(n - i, k, list, 0);
		    list.remove(list.size() - 1);
		  }
	}
}




