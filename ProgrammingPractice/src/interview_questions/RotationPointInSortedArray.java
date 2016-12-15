package interview_questions;

// A program to find rotation point in a sorted array
public class RotationPointInSortedArray {

	public static void main(String[] args) {
		int[] inputArray = {3,4,5,0,1};
		rotationPoint(inputArray);
	}
	
	public static void rotationPoint(int[] input) {
		int start = 0; 
		int end = input.length-1; 
		int mid;
		mid = start + (end-start)/2;
		int lastPoint = input[input.length-1];
		
		while(start <= end) {
			if(input[mid] > lastPoint) {
				start = mid+1;
			}
			
			else if (input[mid] < lastPoint) {
				end = mid -1;
			} 
			else 
				break;
			
			mid = start + (end-start)/2;

		}
		System.out.println("Rotated at index "+ mid +" and element is "+ input[mid]);
	}

}
