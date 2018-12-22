package linkedlist;

public class IntersectionOfTwoLists {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int n = 0;
        //遍历两个链表得到两个长度的差值
        while(a != null){
            n++;
            a = a.next;
        }
        while(b != null){
            n--;
            b = b.next;
        }
//        if(b != a){   //单链表有交点链尾肯定相同
//            return null; 
//        }
        //让指针指向较长链表的头部
        a = n > 0 ? headA : headB;
        b = a == headA ? headB : headA;
        n = Math.abs(n);
        //让较长链表先移动n个单位的距离
        while(n != 0){
            n--;
            a = a.next;
        }
        //a和b同时移动,一定会相交
        while(a != b){
            a = a.next;
            b = b.next;
        }
        return a;
        
        
        //用 哈希表
        
        // ListNode a = headA;
        // ListNode b = headB;
        // HashSet<ListNode> set = new HashSet<>();
        // while(a != null){
        //     set.add(a);
        //     a = a.next;
        // }
        // while(b != null){
        //     if(set.contains(b)){
        //         return b;
        //     }
        //     b = b.next;
        // }
        // return null;
    }
}
