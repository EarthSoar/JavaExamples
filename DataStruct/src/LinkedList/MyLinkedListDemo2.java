
//双向链表
class MyLinkedList {
	private  Node first;//链表中的头结点
	private  Node last;//链表中最后一个节点
	private  int size;//链表中节点的个数
	//链表中的一个节点
	public class Node
	{
		Node prev; //前一个节点
		Node next; //后一个节点
		Object ele; //存储的任意元素
		public Node(Object ele){
			this.ele = ele;
		}
	}

	//向表头添加一个元素
	public void addFirst(Object ele){
		Node node = new Node(ele);
		if(size == 0){//链表中节点个数为0，那么新添加的节点既是头结点也是为尾节点
			this.first = node;
			this.last = node;
		}else{
			//向表头插入一个新节点
			node.next = this.first;
			this.first.prev = node;
			this.first = node;
		}
		size++;
	}
	//向表尾插入一个元素
	public void addLast(Object ele){
		Node node = new Node(ele);
		if(size == 0){
			this.first = node;
			this.last = node;
		}else{
			node.prev = this.last;
			this.last.next = node;
			this.last = node;
		}
		size++;
	}
	//返回链表中第一个元素
	public Object getFirst(){
		return this.first.ele;
	}
	//返回链表中的最后一个元素
	public Object getLast(){
		return this.last.ele;
	}
	//删除链表中的第一个节点
	public void removeFirst(){
		this.first = this.first.next;
		this.first.prev = null;
		size--;
	}
	public void removeLast(){
		this.last = this.last.prev;
		this.last.next = null;
		size--;
	}
	//删除链表中的指定元素
	public void remove(Object ele){
		if(this.first.ele == ele){
			removeFirst();
		}else if(this.last.ele == ele){
			removeLast();
		}else{
			Node current = this.first;
			for(int i = 0; i < size; i++){
				if(current.ele.equals(ele)){
					current.prev.next = current.next;
					current.next.prev = current.prev;
				}
				if(current.next == null){
					return;
				}
				current = current.next;
				
			}
			size--;
		}
	}
	//覆盖toString方法,格式化打印
	public String toString(){
		if(size == 0){
			return "[]";
		}
		StringBuilder sb = new StringBuilder(size*2 - 1);
		sb.append("[");
		Node current = this.first;
		for(int i = 0; i < size; i++){
			sb.append(current.ele);
			if( i != size -1){
				sb.append(",");
			}else{
				sb.append("]");
			}
			current = current.next;
		}
		return sb.toString();
	}
}


public class MyLinkedListDemo
{
	public static void main(String []args){
		MyLinkedList list = new MyLinkedList();
		list.addFirst(11);
		list.addLast(22);
		list.addFirst(10);
		list.addLast(0);
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		list.remove(0);
		System.out.println(list);
		list.removeLast();
		System.out.println(list);

	}
}