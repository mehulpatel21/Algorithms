package interview_questions;

public class LongestIncreasingSubSequence {

	public static void main(String[] args) {
		int[] input = {1,3,4,5,7};
		longestConseqNum(input);
	}
    
	public static void longestConseqNum(int[] input) {
		int subSeqSoFar = 1;
		int longest = 1;
		int startIndex = 0;
		int endIndex = 0;

		for(int i=0; i < input.length-1 ; i++) {
			if(input[i] == input [i+1] - 1) {
				subSeqSoFar++; 
				if(subSeqSoFar > longest) {
					longest = subSeqSoFar; longest = 2;
					startIndex = i + 2 - subSeqSoFar; 
					endIndex = i+2; 
				}
			}

			else {
				subSeqSoFar = 1;
			}
		}

		for(int i = startIndex; i < endIndex; i++) {
			System.out.print(input[i]+ " ");
		}

	}
}
