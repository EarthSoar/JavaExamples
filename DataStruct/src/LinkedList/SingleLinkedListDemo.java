package LinkedList;

public class SingleLinkedListDemo {
	public static void main(String[] args) {
		MySingleLinkedList list = new MySingleLinkedList();
		list.addFirst(2);
		list.addFirst(2);
		list.addFirst(2);
		list.addLast("B");
		list.addLast("C");
		System.out.println(list);
		System.out.println("=======");
		//list.remove(2);
		//list.removeFirst();
		list.delteVal(2);
		System.out.println(list);
	}
}
