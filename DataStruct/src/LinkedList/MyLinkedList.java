package LinkedList;
//双向链表
public class MyLinkedList {
	protected Node first;//链表的第一个节点
	protected Node last;//链表的最后一个节点
	private int size;//链表中元素的个数
//	public MyLinedList(){
//		this.first = first;
//		this.last = last;
//	}
	//覆盖toString方法，格式化打印当前链表中的元素
	public String toString(){
		if(size == 0){
			return("[]");
		} 
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node current = this.first;//把当前第一个节点设为默认值
		for(int i = 0;i < size;i++){
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
	//向链表头中增加一个元素
	public void addFirst(Object ele){
		Node node = new Node(ele);
		if(size == 0){
			this.first = node;
			this.last = node;
		}else{
			//把之前的第一个节点作为新增节点的下一个
			node.next = this.first;
			//把新增节点作为之间第一个节点的上一个节点
			this.first.prev = node;
			//把新增节点作为第一个节点
			this.first = node;
		}
		size++;
	}
	
	//向链表的尾插入一个元素
	public void addLast(Object ele){
		Node node = new Node(ele);
		if(size == 0){//判断链表中是否为空，若为空，那么当前节点既是第一个节点，也是最后一个节点
			this.first = node;
			this.last = node;
		}else{
			//把之前的最后一个节点作为新增节点的prev
			node.prev = this.last;
			//把新增节点作为之前最后一个节点的next
			this.last.next = node;
			//把新增节点作为最后一个节点
			this.last = node;
		}
		size++;
	}
/*
	//查找链表中的元素
	public Object getEle(Object ele){
		Node current = this.first;//从第一个节点开始查找
		for(int i = 0;i < size; i++){
			if(!current.ele.equals(ele)){ //判断元素是否相同
				if(current.next == null){//直到下一个是null说明没找到该元素,则结束函数
					return "null";
				}
				current = current.next;//继续向后查找
			}
		}
		return current.ele;
	}
*/
/*	
	//删除链表中的第一个元素
	public void removeFirst(){
		//Node current = this.first;//从第一个节点开始查找
		this.first = this.first.next;//让所要删除的节点的下一个节点成为第一个节点
		this.first.prev = null;//把新的第一个节点的prev置为null
	}
	//删除链表中的最后一个元素
	public void removeLast(){
		//Node current = this.last;
		this.last = this.last.prev;
		this.last.next = null;
	}
*/
	//删除链表中的一个元素
	public void remove(Object ele) {
		//先找到所要删除的节点
		Node current = this.first;//从第一个节点开始查找
		for(int i = 0;i < size; i++){
			if(!current.ele.equals(ele)){ //判断元素是否相同
				if(current.next == null){//直到下一个是null说明没找到该元素,则结束函数
					return;
				}
				current = current.next;//继续向后查找
			}
		}
		//循环完成后  current.ele == ele;说明找到了这个元素
		
		
		//所要删除的元素是第一个节点、最后一个节点、中间一个节点
		if(current == this.first){
			this.first = current.next;//让所要删除的节点的下一个节点成为第一个节点
			this.first.prev = null;//把新的第一个节点的prev置为null
		}else if(current == this.last){//
			this.last = current.prev;
			this.last.next = null;
		}else{
			current.prev.next = current.next;
			current.next.prev = current.prev;
		}
		size--;
	}
	public class Node{
		public Node(Object ele) {
			this.ele = ele;
		}
		Node prev;//上一个节点
		Node next;//下一个节点
		public Object ele;//任意元素
	}

}
