package miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class SumOfPairInArray {

	public static void main(String[] args) {
		int[] inputArray = {1,2,3,4};
		sumOfPairInArray(inputArray, 7);
	}

	public static void sumOfPairInArray(int[] arr, int m) {
		Map<Integer, Integer> pair = new HashMap<Integer, Integer>();
		
		for(int i=0; i <arr.length; i++) {
			if(pair.containsKey(arr[i])) { 
				System.out.println(arr[i] +", "+ pair.get(arr[i]));
			}
			else {
				pair.put(m-arr[i], arr[i]);
			}
		}
	}
	
}
