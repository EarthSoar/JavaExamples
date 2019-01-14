package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

//判断二叉树是否是完全二叉树
public class IsCBT {
	public static class Node {
		Node left;
		Node right;
		int value;

		public Node(int value) {
			this.value = value;
		}
	}
	
	//按层遍历
	//判断当前节点:
	//1.有右孩子没有左孩子,一定不是完全二叉树
	//2 左右孩子不全(有左没右,左右都没有)，剩余节点都应该是叶子节点
	public static boolean isCBT(Node head) {
		if(head == null) {
			return true;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(head);
		Node left = null;
		Node right = null;
		boolean leaf = false;
		while(!queue.isEmpty()) {
			head = queue.poll();
			left = head.left;
			right = head.right;
			if((leaf && (left != null || right != null)) || (left == null && right != null)) {
				return false;
			}
			if(left != null) {
				queue.add(left);
			}
			if(right != null) {
				queue.add(right);
			}
			//左右孩子不全，开始判断剩余节点是否为叶子节点
			if(left == null || right == null) {
				leaf = true;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.left.left = new Node(5);
		System.out.println(isCBT(node));
	}
}
