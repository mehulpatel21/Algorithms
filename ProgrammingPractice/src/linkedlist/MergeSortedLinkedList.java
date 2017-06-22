package linkedlist;

public class MergeSortedLinkedList {
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}
	}
	
	Node MergeLists(Node list1, Node list2){
		if(list1 == null) return list2;
		if(list2 == null) return list1;
		
		if (list1.data < list2.data) {
		    list1.next = MergeLists(list1.next, list2);
		    return list1;
		} else {
		    list2.next = MergeLists(list2.next, list1);
		    return list2;
		}
	}
}
