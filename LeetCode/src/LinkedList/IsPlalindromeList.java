package linkedlist;

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
	
	//额外空间O(1)
	public static boolean isPlalindrome1(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Node n1 = head;//慢指针
		Node n2 = head;//快指针
		while(n2.next != null && n2.next.next != null) {//判断快指针是否存在下一个节点,再判断是否存在下下个节点
			n1 = n1.next;  //n1走到中间
			n2 = n2.next.next;//n2走到链表的末尾
		}
		n2 = n1.next;//n2 -> 右半部分的第一个节点
		n1.next = null;//把中间下一个置为null
		Node n3 = null;
		while(n2 != null) {//反转右半部分链表
			n3 = n2.next;  //保存下一个节点
			n2.next = n1;  //指针反转
			n1 = n2; 	   //移动指针
			n2 = n3;
		} //最后n2,n3 -> null   n1->末尾
		n3 = n1;//用n3保存最后一个节点  为了最后的还原
		n2 = head;//n2->头部
		boolean res = true;
		while(n1 != null && n2 != null) {
			if(n1.data != n2.data) {
				res = false;
				break;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		//恢复链表
		n1 = n3.next;
		n3.next = null;
		while(n1 != null) {
			n2 = n1.next;
			n1.next = n3;
			n3 = n1;
			n1 = n2;
		}
		return res;
	}
	//反转链表
	public static void conver(Node head) {
		Node n1 = head;
		Node n2 = head.next;
		Node n3 = null;
		n1.next = null;
		while(n2 != null) {
			n3 = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = n3;
		}
		head = n1;
	}
	public static void printNode(Node node) {
		while(node != null) {
			StringBuilder sb = new StringBuilder(20);
			if(node.next != null) {
				sb.append(node.data).append("->");
			}else {
				sb.append(node.data).append("->null");
			}
			System.out.print(sb);
			node = node.next;
		}
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
		head.next = new Node(1);
		head.next.next = new Node(2);
		head.next.next.next = new Node(1);
		head.next.next.next.next = new Node(1);
		System.out.println(isPlalindrome1(head));
//		printNode(head);
//		conver(head);
		printNode(head);
	}
}
