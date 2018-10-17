package LinkedList;

public class MyLinkedListDemo {
	public static void  main(String[]args){
		MyLinkedList list = new MyLinkedList();
		list.addFirst(111);
		list.addLast(222);
		list.addFirst(111);
		list.addLast(222);
		
		System.out.println(list);//打印当前链表中的所有元素
		list.remove(111);
		System.out.println(list);
		
	}
}
