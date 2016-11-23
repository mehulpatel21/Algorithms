package sorting;

public class InsertionSort {

	public static void main(String[] args) {
		InsertionSort obj  = new InsertionSort();
		int arr[] = {12, 11, 13, 5, 6};
		obj.insertionSort(arr);
		
		System.out.println("Sorted Array ");
		for(int i=0; i<arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	
	public int[] insertionSort(int[] list){
		for(int i=1; i<list.length; i++){
			int key=list[i];
			int j=i-1;
			while(j >=0  && key< list[j]){
				int temp = list[j];
				list[j] = list[j+1];
				list[j+1] = temp;
				j--;
			}
		}
		
		return list;
		
	}

}
