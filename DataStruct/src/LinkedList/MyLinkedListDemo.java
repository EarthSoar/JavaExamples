package LinkedList;

public class MyLinkedListDemo {
	public static void  main(String[]args){
		MyLinkedList list = new MyLinkedList();
		list.addFirst(111);
		list.addLast(222);
		list.addFirst(111);
		list.addLast(222);
		
		System.out.println(list);//��ӡ��ǰ�����е�����Ԫ��
		list.remove(111);
		System.out.println(list);
		
	}
}
