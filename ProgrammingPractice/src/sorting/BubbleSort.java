package sorting;

public class BubbleSort {

	public static void main(String[] args) {
		new BubbleSort();

	}
	public BubbleSort(){
		int[] arr = new int[]{11, 20, 31, 49, 101, 29};
		System.out.println("Before sorting: ");
		printArray(arr);
		
		bubbleSort(arr);
		
		System.out.println("After sorting: ");
		printArray(arr);
		
	}
	public void bubbleSort(int[] arr){
		if(arr == null){
			return;
		}
		boolean sorted = true;
		for(int i=0; i<arr.length; i++){
			for(int j=1; j<arr.length-i; j++){
				if(arr[j-1] > arr[j]){
					sorted = false;
					int temp = arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp;
				}
			}
			if(sorted){
				break;
			}
		}
	}
	
	public void printArray(int[] arr){
		for(int i=0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}

}
