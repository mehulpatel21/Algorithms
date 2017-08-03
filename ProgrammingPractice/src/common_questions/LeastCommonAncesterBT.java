package common_questions;

public class LeastCommonAncesterBT {
	class Node{
		Node left, right;
		int data;
		public Node(int data){
			this.data = data;
		}
	}
	// Time complexity O(n), space O(h)
    public Node leastCommonAncesterBT(Node root, Node n1, Node n2){
        if(root == null){
            return null;
        }
        
        if(root == n1 || root == n2){
            return root;
        }
        
        Node left = leastCommonAncesterBT(root.left, n1, n2);
        Node right = leastCommonAncesterBT(root.right, n1, n2);

        if(left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }
}
