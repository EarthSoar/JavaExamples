package linkedlist.medium;

/**
 * 有环的单链表,返回如环的第一个节点
 * @author Willing
 *
 */
public class LinkedListCycle2 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		ListNode slow = head.next;
		ListNode fast = head.next.next;
		while (slow != fast) { // 当快指针指针和满指针相遇说明存在环
			if (fast.next == null || fast.next.next == null) {
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = head; // 让快指针回到链头,一次走一个
		while (slow != fast) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
}
