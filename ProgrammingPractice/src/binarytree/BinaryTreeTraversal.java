package binarytree;

public class BinaryTreeTraversal{
	class Node{
		private int data;
		private Node left;
		private Node right;
		
		public Node(int data){
			this.data = data;
		}
		public Node getLeft(){
			return left;
		}
		public void setLeft(Node left){
			this.left = left;
		}
		public Node getRight(){
			return right;
		}
		public void setRight(Node right){
			this.right = right;
		}
		public int getData(){
			return data;
		}
		public void setData(int data){
			this.data = data;
		}
	}
	
	private Node rootNode;
	public static void main(String[] args){
		new BinaryTreeTraversal();
	}
	
	public BinaryTreeTraversal(){
		addNode(rootNode, 45); 
		addNode(rootNode, 25); 
		addNode(rootNode, 75); 
		addNode(rootNode, 15); 
		addNode(rootNode, 35); 
		
		System.out.println("In Order Traversal :");
		printTreeInOrder(rootNode);
		   
		System.out.println("\nPre Order Traversal :");
		printTreePreOrder(rootNode);
		   
		System.out.println("\nPost Order Traversal :");
		printTreePostOrder(rootNode);
	}
	
	private void printTreePreOrder(Node rootNode) {
		
	}
	private void printTreeInOrder(Node rootNode) {
		
	}
	private void printTreePostOrder(Node rootNode) {
		
	}
	
	private void addNode(Node rootNode, int data){
		if(rootNode == null){
			Node node = new Node(data);
			this.rootNode = node;
		} else {
			addNodeInProperPlace(rootNode, data);
		}
	}
	private void addNodeInProperPlace(Node rootNode, int data){
		if(data > rootNode.getData()){
			if(rootNode.getRight() != null){
				addNode(rootNode.right, data);
			} else {
				Node temp = new Node(data);
				rootNode.setRight(temp);
			}
		} else if(data < rootNode.getData()){
			if(rootNode.getLeft() != null){
				addNode(rootNode.left, data);
			} else {
				Node temp = new Node(data);
				rootNode.setLeft(temp);
			}
		}
	}
}