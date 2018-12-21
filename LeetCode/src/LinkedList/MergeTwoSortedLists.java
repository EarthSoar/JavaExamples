package linkedlist;

/**
 *	有序链表交叉合并
 *	Input: 1->2->4, 1->3->4
 *	Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode newList = new ListNode(0);// new LinkedList
		ListNode cur = newList;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		cur.next = (l1 != null) ? l1 : l2;
		return newList.next;
	}
}
