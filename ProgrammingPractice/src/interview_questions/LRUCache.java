package interview_questions;

import java.util.HashMap;

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
