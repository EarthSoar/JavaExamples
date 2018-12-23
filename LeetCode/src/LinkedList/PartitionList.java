package linkedlist.medium;

/**
 * 链表的荷兰国旗问题
 * 
 * @author Willing
 *
 */
public class PartitionList {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode partition(ListNode head, int x) {
		ListNode smaller = new ListNode(0);// 较小值链表
		ListNode bigger = new ListNode(0);// 较大值链表
		ListNode s = smaller;
		ListNode b = bigger;
		while (head != null) {
			if (head.val < x) { // 跟到小值链表后面
				s.next = head;
				s = s.next;
			} else {
				b.next = head;
				b = b.next;
			}
			head = head.next;
		}
		s.next = bigger.next; // 把较小值链表的最后执行较大值链表的第一个节点
		b.next = null; // 把较大值最后置为null防止产生环
		return smaller.next;
	}
}
