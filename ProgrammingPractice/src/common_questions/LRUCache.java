package common_questions;

import java.util.HashMap;
/*
 	LRUCache solution:
 	Typically LRU cache is implemented using a doubly linked list and a hash map.
	Doubly Linked List is used to store list of pages with most recently used page at the start of the list. 
	So, as more pages are added to the list, least recently used pages are moved to the end of the list with page at tail 
	being the least recently used page in the list.
	Hash Map (key: page number, value: page) is used for O(1) access to pages in cache
	
	When a page is accessed, there can be 2 cases:
	1. Page is present in the cache - If the page is already present in the cache, we move the page to the start of the list.
	2. Page is not present in the cache - If the page is not present in the cache, we add the page to the list. 
	How to add a page to the list:
	   a. If the cache is not full, add the new page to the start of the list.
	   b. If the cache is full, remove the last node of the linked list and move the new page to the start of the list.
*/

class Node{
	int key, value;
	Node prev, next;
	public Node(int key, int value){
		this.key = key;
		this.value = value;
	}
}

public class LRUCache {
	int capacity;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	Node head = null;
	Node end = null;
	
	public LRUCache(int capacity){
		this.capacity = capacity;
	}
	
	public void remove(Node n){
		if(n.prev != null){
			n.prev.next = n.next;
		} else {
			head = n.next;
		}
		
		if(n.next != null){
			n.next.prev = n.prev;
		} else {
			end = n.prev;
		}
	}
	
	public void setHead(Node n){
		n.next = head;
		n.prev = null;
		
		if(head != null){
			head.prev = n;
		}
		
		head = n;
		if(end == null){
			end = head;
		}
	}
	
	public int get(int key){
		if(map.containsKey(key)){
			Node n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}
		return -1;
	}
	
	public void put(int key, int value){
		if(map.containsKey(key)){
			Node old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		} else {
			Node newCreated = new Node(key, value);
			if(map.size() >= capacity){
				map.remove(end.key);
				remove(end);
				setHead(newCreated);
			} else {
				setHead(newCreated);
			}
			map.put(key, newCreated);
		}
	}
	
}
