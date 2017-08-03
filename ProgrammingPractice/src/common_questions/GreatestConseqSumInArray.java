package common_questions;

public class GreatestConseqSumInArray {
	public static void main(String[] args){
		int[] nums = {-1,-2,-3,4,5,6,1,0};
		System.out.println(maxSubArray(nums));
	}
	
	public static int maxSubArray(int[] nums){
		if(nums == null || nums.length == 0){return 0;}
		int max = nums[0];
		int sum = nums[0];
		for(int i=1; i<nums.length; i++){
			if(sum < 0){
				sum = nums[i];
			} else {
				sum += nums[i];
			}
			max = Math.max(max, sum);
		}
		return max;
	}
}
