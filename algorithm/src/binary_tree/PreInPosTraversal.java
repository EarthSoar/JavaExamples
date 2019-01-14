package binary_tree;

import java.util.Stack;

public class PreInPosTraversal {
	public static class Node{
		Node left;
		Node right;
		int value;
		public Node(int value) {
			this.value = value;
		}
	}
	//=======递归======
	public static void preOrderRecur(Node head) {
		if(head == null) {
			return;
		}
		System.out.print(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}
	public static void inOrderRecur(Node head) {
		if(head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.println(head.value);
		inOrderRecur(head.right);
	}
	public static void posOrderRecur(Node head) {
		if(head == null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.println(head.value);
	}
	//=======非递归=======
	public static void preOrderUnRecur(Node head) {
		if(head != null) {
			Stack<Node> stack = new Stack<>();
			stack.push(head);
			while(!stack.empty()) {
				head = stack.pop();
				System.out.print(head.value + " ");
				if(head.right != null) {
					stack.push(head.right);
				}
				if(head.left != null) {
					stack.push(head.left);
				}
			}
		}
	}
	public static void inOrderUnRecur(Node head) {
		if(head != null) {
			Stack<Node> stack = new Stack<>();
			while(!stack.isEmpty() || head != null) {
				if(head != null) {
					stack.push(head);
					head = head.left;
				}else {
					head = stack.pop();
					System.out.print(head.value + " ");
					head = head.right;
				}
			}
		}
	}
	public static void posOrderUnRecur(Node head) {
		if(head != null) {
			Stack<Node> stack = new Stack<>();
			Stack<Node> help  = new Stack<>();
			stack.add(head);
			while(!stack.isEmpty()) {
				head = stack.pop();
				help.add(head);
				if(head.left != null) {
					stack.push(head.left);
				}
				if(head.right != null) {
					stack.push(head.right);
				}
			}

			while(!help.isEmpty()){
				System.out.print(help.pop().value + " ");
			}
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
		
		//preOrderRecur(head);
		//inOrderRecur(head);
		//posOrderRecur(head);
		
		//preOrderUnRecur(head);
		//inOrderUnRecur(head);
		posOrderUnRecur(head);
	}
}
