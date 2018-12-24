package linkedlist.medium;

public class AddTwoNumbers {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode res = dummy;
		int carry = 0;// 低位向高位的进位
		while (l1 != null || l2 != null) {
			int a = l1 == null ? 0 : l1.val; // 某一个数位数少,后面补0
			int b = l2 == null ? 0 : l2.val;
			int sum = carry + a + b;
			carry = sum / 10; // 取和的十位
			res.next = new ListNode(sum % 10);// 取和的个位
			res = res.next;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (carry > 0) { // 最高位向前的进位
			res.next = new ListNode(carry);
		}
		return dummy.next;
	}
}
