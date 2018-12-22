package linkedlist;

public class RemoveElements {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	public ListNode removeElements(ListNode head, int val) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode cur = h;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return h.next;
    }
}
