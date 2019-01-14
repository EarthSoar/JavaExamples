package binary_tree;

public class SuccessorNode {
	public static class Node{
		int value;
		Node left;
		Node right;
		Node parent;
		public Node(int value) {
			this.value = value;
		}
	}
	public static Node getSucessor(Node node) {
		if(node == null) {
			return node;
		}
		if(node.right != null) {
			return getLeftMost(node);
		}else {
			Node parent = node.parent;
			while(parent != null &&  parent.left != node) {
				node = parent;
				parent = parent.parent;
			}
			return parent;
		}
	}
	private static Node getLeftMost(Node node) {
		if(node == null) {
			return null;
		}
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
}
