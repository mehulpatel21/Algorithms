package sorting;

public class SelectionSort {
	public static void main(String[] args) {
		new SelectionSort();
	}
	
	public SelectionSort(){
		int[] arr = new int[]{10,100,20,21,27,9,6};
		System.out.println("Before sorting: ");
		printArray(arr);
		
		selectionSort(arr);
		
		System.out.println("After Sorting: ");
		printArray(arr);
	}

	public void selectionSort(int[] arr){
		for(int i=0; i<arr.length; i++){
			int minIndex = i;
			for(int j=i+1; j<arr.length; j++){
				if(arr[minIndex] > arr[j]){
					minIndex = j;
				}
			}
			if(minIndex != i){
				int temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
			}
		}
		
	}
	
	public void printArray(int[] arr){
		for(int i=0; i <arr.length - 1; i++){
			System.out.println(arr[i]);
		}
	}
	

}
