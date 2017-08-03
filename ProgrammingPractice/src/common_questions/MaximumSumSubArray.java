package common_questions;

public class MaximumSumSubArray {

	public static void main(String[] args) {
		int a[] = { -2, -3, -4, -1, -2, -1, -5, -3 };
		maxSumSubArray(a);
	}

	public static void maxSumSubArray(int[] arr) {
		int maxSoFar = arr[0];
		int s = 0, start = 0, end = 0;
 
		int maxEndingHere = arr[0];
		for (int i = 1; i < arr.length; i++) {
			maxEndingHere += arr[i];
 
			if (maxEndingHere < arr[i]) {
				maxEndingHere = arr[i];
				s = i;
			}
 
			if (maxEndingHere > maxSoFar) {
				start = s;
				end = i;
				maxSoFar = maxEndingHere;
			}
		}
 
		System.out.println("start index : " + start + " end index : " + end + " maxSumSubarray : " + maxSoFar);
	}
}
