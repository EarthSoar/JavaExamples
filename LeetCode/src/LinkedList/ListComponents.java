package linkedlist.medium;

import java.util.HashSet;

public class ListComponents {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public int numComponents(ListNode head, int[] G) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < G.length; i++) {
			set.add(G[i]);
		}
		int n = 0;
		ListNode cur = head;
		while (cur != null) {
			ListNode pre = cur;
			while (cur != null && set.contains(cur.val)) {
				cur = cur.next;
			}
			if (pre != cur) {// 保证存在上面节点的值存在于set中,如果压根不存在就不增加
				n++;
			}
			if (cur != null) {
				cur = cur.next;
			}
		}
		return n;
	}
}
