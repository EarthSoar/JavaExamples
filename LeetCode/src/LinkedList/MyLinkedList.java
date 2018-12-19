package linkedlist;

public class MyLinkedList {
	private int size;
	private Node head;
	private Node tail;

	class Node {
		Node next;
		Node prev;
		int val;

		Node(int val) {
			this.val = val;
		}
	}

	/** Initialize your data structure here. */
	public MyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {
		if(index >= size || index < 0) {
			return -1;
		}
		Node cur = this.head;
		int i = 0;
		while (i != index) {
			cur = cur.next;
			i++;
		}
		return cur.val;
	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		Node newNode = new Node(val);
		if (size == 0) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
		}
		size++;
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		Node newNode = new Node(val);
		if (size == 0) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.prev = this.tail;
			tail.next = newNode;
			this.tail = newNode;
		}
		size++;
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted.
	 */
	public void addAtIndex(int index, int val) {
		if (index > size || index < 0) {
			return;
		}
		if (index == 0) {
			addAtHead(val);
			return;
		}
		if (index == size) {
			addAtTail(val);
			return;
		}
		Node newNode = new Node(val);
		Node cur = this.head;
		int i = 0;
		while (i != index) {
			cur = cur.next;
			i++;
		}
		// 在cur节点前面插入新节点
		newNode.prev = cur.prev;
		cur.prev.next = newNode;
		newNode.next = cur;
		cur.prev = newNode;
		size++;
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if(index >= size) {
			return;
		}
		Node cur = this.head;
		int i = 0;
		while (i != index) {
			cur = cur.next;
			i++;
		}
		if(i == 0) {
			this.head = cur.next;
			this.head.prev = null;
		}else if(i == size - 1) {
			this.tail = cur.prev;
			this.tail.next = null;
		}else {
			cur.prev.next = cur.next;
			cur.next.prev = cur.prev;
		}
		size--;
	}
	public String toString(){
		if(size == 0){
			return("[]");
		} 
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node current = this.head;//把当前第一个节点设为默认值
		for(int i = 0;i < size;i++){
			sb.append(current.val);
			if( i != size -1){
				sb.append(",");
			}else{
				sb.append("]");
			}
			current = current.next;
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.addAtHead(1);
		linkedList.addAtTail(3);
		linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
		//int res = linkedList.get(1);            // returns 2
		linkedList.deleteAtIndex(1);  // now the linked list is 1->3
		int res1 = linkedList.get(1);            // returns 3
		System.out.println(linkedList);
		System.out.println(res1);
	}
}
