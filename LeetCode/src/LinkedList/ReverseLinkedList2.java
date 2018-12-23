package linkedlist.medium;

public class ReverseLinkedList2 {
	static public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy= new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = null;
        ListNode nex = null;
        for(int i = 0; i < m - 1; i++){
            pre = pre.next;
        }
        ListNode temp = pre;
        cur = pre.next;
        for(int i = m; i <= n; i++){
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        temp.next.next = cur;
        temp.next = pre;
        return dummy.next;
    }
}
