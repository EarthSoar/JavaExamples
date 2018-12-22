package linkedlist;

public class IsCycleList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	 public boolean hasCycle(ListNode head) {
	        if(head == null || head.next == null || head.next.next == null){
	            return false;
	        }
	        ListNode slow = head.next;
	        ListNode fast = head.next.next;
	        
	        while(slow != fast){   //快指针和慢指针若相遇则一定存在环
	            if(fast.next == null || fast.next.next == null){
	                return false;
	            }
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        return true;
	    }
}
