package binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//二叉树的序列化和反序列化
public class SerializeAndReconstructTree {
	public static class Node {
		Node left;
		Node right;
		int value;

		public Node(int value) {
			this.value = value;
		}
	}
	
	//按先序遍历序列化
	public static String serialByPre(Node head) {
		if (head == null) {
			return "#_";
		}
		String res = head.value + "_";
		res += serialByPre(head.left);
		res += serialByPre(head.right);
		return res;
	}
	//按先序遍历反序列化
	public static Node reconByPreString(String preStr) {
		String[] values = preStr.split("_");
		Queue<String> queue = new LinkedList<>();
		for (int i = 0; i < values.length; i++) {
			queue.add(values[i]);
		}
		return reconPreOrder(queue);
	}

	public static Node reconPreOrder(Queue<String> queue) {
		String value = queue.poll();
		if (value.equals("#")) {
			return null;
		}
		Node head = new Node(Integer.valueOf(value));
		head.left = reconPreOrder(queue);
		head.right = reconPreOrder(queue);
		return head;
	}

	// 按层序列化
	public static String serialByLevel(Node head) {
		if (head == null) {
			return "#_";
		}
		String res = head.value + "_";
		Queue<Node> queue = new LinkedList<>();
		queue.add(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			if (head.left != null) {
				res += head.left.value + "_";
				queue.add(head.left);
			} else {
				res += "#_";
			}

			if (head.right != null) {
				res += head.right.value + "_";
				queue.add(head.right);
			} else {
				res += "#_";
			}
		}
		return res;
	}
	// 按层反序列化
	public static Node reconByLevelString(String levelStr) {
		String[] values = levelStr.split("_");
		int index = 0;
		// 头节点
		Node head = generateNodeByString(values[index++]);
		Queue<Node> queue = new LinkedList<>();
		if (head != null) {
			queue.add(head);
		}
		Node node = null;
		while (!queue.isEmpty()) {
			node = queue.poll();
			node.left = generateNodeByString(values[index++]);
			node.right = generateNodeByString(values[index++]);

			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
		return head;
	}

	//构造节点的方法
	public static Node generateNodeByString(String value) {
		if (value.equals("#")) {
			return null;
		}
		return new Node(Integer.valueOf(value));
	}

	// ================================
	public static void preOrderUnRecur(Node head) {
		if (head != null) {
			Stack<Node> stack = new Stack<>();
			stack.push(head);
			while (!stack.empty()) {
				head = stack.pop();
				System.out.print(head.value + " ");
				if (head.right != null) {
					stack.push(head.right);
				}
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}
	}
	//层序遍历
	public static void levelOrder(Node head) {
		if(head == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(head);
		while(!queue.isEmpty()) {
			head = queue.poll();
			if(head.left != null) {
				queue.add(head.left);
			}
			if(head.right != null) {
				queue.add(head.right);
			}
			System.out.print(head.value + " ");
		}
	}
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);
		
		String res = serialByPre(head);
		System.out.println(res);

		Node node = reconByPreString(res);
		preOrderUnRecur(node);
		System.out.println();
		System.out.println("===============");
		String levelStr = serialByLevel(head);
		System.out.println(levelStr);
		Node leNode = reconByLevelString(levelStr);
		preOrderUnRecur(leNode);
		System.out.println();
		levelOrder(head);
	}
}
