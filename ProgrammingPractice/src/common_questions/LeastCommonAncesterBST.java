package common_questions;

public class LeastCommonAncesterBST {
	class Node{
		Node left, right;
		int data;
		public Node(int data){
			this.data = data;
		}
	}
	public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root.data > Math.max(p.data, q.data)) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.data < Math.min(p.data, q.data)) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
