package linkedlist;

public class ReverseList {
	static public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	public static ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode node1 = null;// prev
		ListNode node2 = head;// cur
		ListNode node3 = null;// next
		while (node2 != null) {
			node3 = node2.next;
			node2.next = node1;
			node1 = node2;// move node1
			node2 = node3;// move node2
		}
		return node1;
	}
	public static void printNode(ListNode node) {
		while(node != null) {
			StringBuilder sb = new StringBuilder(20);
			if(node.next != null) {
				sb.append(node.val).append("->");
			}else {
				sb.append(node.val).append("->null");
			}
			System.out.print(sb);
			node = node.next;
		}
	}
	public static void main(String[] args) {
		ListNode head = null;
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		printNode(head);
		ListNode h = reverseList(head);
		System.out.println();
		printNode(h);
	}
}
