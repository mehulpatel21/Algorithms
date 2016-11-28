package sorting;

public class QuickSort {
	private int[] numbers;
	private int len;
	
	private void sort(int[] arr){
		if(arr.length ==0 || arr == null){
			return;
		}
		this.numbers = arr;
		len = arr.length;
		quickSort(0, len-1);
	}
	
	private void quickSort(int low, int high){
		int pivot = numbers[low + (high-low)/2];
		int i = low, j = high;
		
		while(i <= j){
			while(numbers[i] < pivot){
				i++;
			}
			while(numbers[j] > pivot){
				j--;
			}
			if(i<=j){
				int temp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = temp;
				i++;
				j--;
			}
			
			if(low < j){
				quickSort(low, j);
			}
			if(i < high){
				quickSort(i, high);	
			}
		}
	}
	
	public static void printArray(int[] arr){
		for(int i=0; i < arr.length; i++){
			System.out.println(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		int[] arr = {10,1, 100000, 0, 2, 100, 11};
		
		System.out.println("Before sorting");
		printArray(arr);
		
		QuickSort obj = new QuickSort();
		obj.sort(arr);
		
		System.out.println("After sorting");
		printArray(arr);
	}
}
