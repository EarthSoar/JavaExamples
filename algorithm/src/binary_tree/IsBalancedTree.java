package binary_tree;

public class IsBalancedTree {
	public static class Node {
		Node left;
		Node right;
		int value;

		public Node(int value) {
			this.value = value;
		}
	}

	public static boolean isBalance(Node node) {
		boolean[] b = new boolean[1];
		b[0] = true;
		getHeight(node, 1, b);
		return b[0];
	}

	private static int getHeight(Node node, int level, boolean[] b) {
		if (node == null) {
			return level;
		}
		int l = getHeight(node.left, level + 1, b);
		if (!b[0]) {
			return level;
		}
		int r = getHeight(node.right, level + 1, b);
		if (!b[0]) {
			return level;
		}
		if (Math.abs(l - r) > 1) {
			b[0] = false;
		}
		return Math.max(l, r);
	}
	
	
	public static void main(String[] args) {
		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.left.left = new Node(5);
		System.out.println(isBalance(node));
	}
}
