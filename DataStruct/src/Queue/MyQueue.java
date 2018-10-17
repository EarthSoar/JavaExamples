package Queue;

import LinkedList.MyLinkedList;

/*
 *队列，有双向队列和单向队列，
 *单向队列中，只允许在队头删除，在队尾插入；
 *双向队列中，可以在队头/队尾删除,在队头/队尾插入；
 *  java中的队列用linkedlist实现
 * */


//双向队列
public class MyQueue extends MyLinkedList {
	//在队头插入
	public void addFirst(Object ele){
		super.addFirst(ele);
	}
	
	//删除队头元素
	public void removeFirst(){
		remove(this.first.ele);
	}
	public void removeLast(){
		remove(this.last.ele);
	}
	//在队尾插入
	public void addLast(Object ele){
		super.addLast(ele);
	}
	//队头元素
	public Object getFirst(){
		return this.first.ele;
	}
	//队尾元素
	public Object getLast(){
		return this.last.ele;
	}
	
}
