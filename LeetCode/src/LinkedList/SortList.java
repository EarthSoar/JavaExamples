package linkedlist.medium;

public class SortList {
	static public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //快慢指针找到中点
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        
        //递归排序两个链表
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
    
        return merge(l1, l2);
    }
    public ListNode merge(ListNode cur1,ListNode cur2){
        ListNode h = new ListNode(0);
        ListNode help = h;
        while(cur1 != null && cur2 != null){
            if(cur1.val < cur2.val){
                help.next = cur1;
                cur1 = cur1.next;
            }else{
                help.next = cur2;
                cur2 = cur2.next;
            }
            help = help.next;
        }
        if(cur1 != null){
            help.next = cur1;
        }
        if(cur2 != null){
            help.next = cur2;
        }
        return h.next;
    }
}
