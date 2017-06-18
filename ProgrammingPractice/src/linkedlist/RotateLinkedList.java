package linkedlist;

public class RotateLinkedList {
	Node head;
	class Node {
		int data;
		Node next;
		Node(int d){
			data=d;
			next = null;
		}
	}
	
	
	
	void addToLinkedList(int new_data){
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}
	
	void printList(){
		Node temp = head;
		while(temp != null){
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		RotateLinkedList mylist = new RotateLinkedList();
		for(int i=60; i>=10; i-=10){
			mylist.addToLinkedList(i);
		}
		System.out.println("Given list");
		mylist.printList();
		
		
		System.out.println("After rotation");
		mylist.printList();
	}

}
