package binary_tree;

import java.util.Stack;

//判断二叉树是否为搜索二叉树
public class IsBST {
	public static class Node {
		Node left;
		Node right;
		int value;

		public Node(int value) {
			this.value = value;
		}
	}

	//中序遍历的结果是按照升序排列的
	public static boolean isBST(Node head) {
		if (head != null) {
			Stack<Node> stack = new Stack<>();
			int pre = Integer.MIN_VALUE;
			while (!stack.isEmpty() || head != null) {
				if (head != null) {
					stack.push(head);
					head = head.left;
				} else {
					head = stack.pop();
					System.out.print(head.value + " ");
					if(head.value < pre) {
						return false;
					}
					pre = head.value;
					head = head.right;
				}
			}
		}
		return true;
	}
}
