package list;
import java.util.*;
public class LinkedListDemo {
	public static void main(String[]args){
		LinkedList<String> list = new LinkedList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		System.out.println(list);
		//双向链表中没有索引的概念，但是集合框架出现后，LinkedList实现了List接口，所以有了get(index)f
		//方法，当然，这个方法尽量不要使用
		//System.out.println(list.get(1));
		
		
		
	}
}
