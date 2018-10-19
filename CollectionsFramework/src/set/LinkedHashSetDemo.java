package set;

import java.util.*;

/**
 * @author 15626
 *  LinkedHashSet,从名字可以看出，底层采用的是链表和哈希表算法
 *  链表保证元素的插入顺序，HashSet来保证元素不重复
 *  此类继承于LinkedHashList，因为有了Linked,因此效率相对较低了
 */
public class LinkedHashSetDemo{
	public static void main(String []args){
		Set<String> set = new LinkedHashSet<String>();
		set.add("111");
		set.add("abc");
		set.add("abc");
		set.add("AAA");
		set.add("ff");
		System.out.println(set);// [111, abc, AAA, ff]
	}
}
