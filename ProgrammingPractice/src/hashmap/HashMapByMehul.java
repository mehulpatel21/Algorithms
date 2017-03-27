package hashmap;

/**
 * @author Mehul Patel
 * Created Date: 03/27/2017
 * HashMap implementation in Java (A simple version)
 */
public class HashMapByMehul {
	class Node{
		private String key;
		private String value;
		private Node next;
		
		public Node(){}
		public Node(String key, String value){
			this.key = key;
			this.value = value;
		}
		
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		
	}
	
	// Initial size of the bucket array
	private int BUCKET_SIZE = 256;
	private Node bucketArray[] = new Node[BUCKET_SIZE];
	
	public HashMapByMehul(){}
	public HashMapByMehul(int initialsize){
		this.BUCKET_SIZE = initialsize;
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void put(String key, String value){
		// Get the hash code (basically this is the index at which we will store data)
		int hash = Math.abs(key.hashCode() % BUCKET_SIZE);
		
		// Create the node to add to the linkedlist
		Node entry = new Node(key,value);
		
		// Inserting the node to the bucket array at the index retrieved by hash
		if(bucketArray[hash] == null){
			// No collision, insert the node
			bucketArray[hash] = entry;
		} else {
			// Collision is detected and we have to place the node at the end of the linkedlist
			Node current = bucketArray[hash];
			while(current.next != null){
				// Checking if the key exists
				if(current.getKey().equals(entry.getKey())){
					// Replace the keys value with the new one
					current.setValue(entry.getValue());
					return;
				}
				current = current.next;
			}
			// Here is where current.next == null So we will do the following
			current.next = entry;
		}
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public String get(String key){
		// Get the hash
		int hash = Math.abs(key.hashCode() % BUCKET_SIZE);
		// Search for the key in linkedlist
		Node node = bucketArray[hash];
		// Travel the linkedlist
		while(node != null){
			if(node.getKey().equals(key)){
				return node.getValue();
			}
			node = node.getNext();
		}
		return null;
	}

}
