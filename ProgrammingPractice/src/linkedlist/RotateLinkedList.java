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

    void rotate(int k)
    {
        if (k == 0) return;
        Node current  = head;

        int count = 1;
        while (count < k && current !=  null)
        {
            current = current.next;
            count++;
        }
 
        if (current == null)
            return;

        Node kthNode = current;
        while (current.next != null)
            current = current.next;
        
        current.next = head;
        head = kthNode.next;
        kthNode.next = null;
 
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
		
		mylist.rotate(4);
		
		System.out.println("After rotation");
		mylist.printList();
	}

}
