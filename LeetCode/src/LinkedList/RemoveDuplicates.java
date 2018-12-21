package linkedlist;
/*
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 */
public class RemoveDuplicates {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode cur = head;
		while (cur != null && cur.next != null) {
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return head;
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
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode node = new RemoveDuplicates().deleteDuplicates(head);
		printNode(node);
	}
}
