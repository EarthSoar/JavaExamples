package Queue;

public class MyQueueDemo {
	public static void main(String[]args){
		MyQueue q = new MyQueue();
		q.addFirst(11);
		q.addLast(121);
		q.addLast(22);
		q.addFirst(333);
		System.out.println(q);
		q.removeFirst();
		System.out.println(q);
		q.removeLast();
		System.out.println(q);
		System.out.println(q.getLast());
	}

}
