package linkedlist;

/**
 * 	删除链表中所有相同的元素
 * @author Willing
 *
 */
public class RemoveDuplicates2 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode h = new ListNode(0);
		h.next = head; // add a head node
		ListNode pre = h; // 开始指向头结点
		ListNode cur = head;
		while (cur != null) {
			while (cur.next != null && cur.val == cur.next.val) {
				cur = cur.next;
			}
			if (pre.next == cur) {
				pre = cur;
			} else {
				pre.next = cur.next;
			}
			cur = cur.next;
		}
		return h.next;
	}

	public static void printNode(ListNode node) {
		while (node != null) {
			StringBuilder sb = new StringBuilder(20);
			if (node.next != null) {
				sb.append(node.val).append("->");
			} else {
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
		ListNode node = new RemoveDuplicates2().deleteDuplicates(head);
		printNode(node);
	}
}
