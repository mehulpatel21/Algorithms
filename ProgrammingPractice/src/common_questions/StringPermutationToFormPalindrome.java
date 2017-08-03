package common_questions;

public class StringPermutationToFormPalindrome {
	public static void main(String[] args){
		StringPermutationToFormPalindrome obj = new StringPermutationToFormPalindrome();
		System.out.println(obj.canPermutePalindrome("carerac"));
	}
	public boolean canPermutePalindrome(String string){
		int[] arrayMap = new int[128];
		int count=0;
		for(int i=0; i<string.length(); i++){
			arrayMap[string.charAt(i)]++;
			if(arrayMap[string.charAt(i)] %2 == 0){
				count--;
			} else{
				count++;
			}
		}
		return count <= 1;
	}
}
