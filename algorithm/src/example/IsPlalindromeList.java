package example;

import java.util.Stack;

/**
 * @author Willing
 *  给定一个链表的头节点head，请判断该链表是否为回文结构
 *例如： 1->2->1，返回true。 1->2->2->1，返回true。
 * 	   15->6->15，返回true。 1->2->3，返回false。
 */
public class IsPlalindromeList {
	
	
	//用一个栈来辅助,额外空间需要n
	public static boolean isPlalindrome(Node head) {
		Stack<Node> stackNode = new Stack<>();
		Node currentNode = head;
		while(currentNode != null) {
			stackNode.push(currentNode);
			currentNode = currentNode.next;
		}
		currentNode = head;
		while(currentNode != null) {
			if(currentNode.data != stackNode.pop().data) {
				return false;
			}
			currentNode = currentNode.next;
		}
		return true;
	}
	
	//节点数据结构
	public static class Node{
		int data;
		Node next;
		public Node(int data){
			this.data = data;
		}
	}
	public static void main(String[] args) {
		Node head = null;
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(2);
		head.next.next.next = new Node(1);
		System.out.println(isPlalindrome(head));
	}
}
