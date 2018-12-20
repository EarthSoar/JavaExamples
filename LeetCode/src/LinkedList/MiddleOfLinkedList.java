package linkedlist;

/**
 * 	Given a non-empty, singly linked list with head node head,
 *  return a middle node of linked list. If there are two middle nodes,
 *  return the second middle node.
 */
public class MiddleOfLinkedList {
	class Solution {
		public class ListNode {
			int val;
			ListNode next;

			ListNode(int x) {
				val = x;
			}
		}

		public ListNode middleNode(ListNode head) {
			ListNode slow = head;
			ListNode fast = head;
			while (fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			if (fast.next != null) {
				slow = slow.next;
				return slow;
			}
			return slow;
		}
	}
}
