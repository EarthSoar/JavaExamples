package Queue;

import LinkedList.MyLinkedList;

/*
 *���У���˫����к͵�����У�
 *��������У�ֻ�����ڶ�ͷɾ�����ڶ�β���룻
 *˫������У������ڶ�ͷ/��βɾ��,�ڶ�ͷ/��β���룻
 *  java�еĶ�����linkedlistʵ��
 * */


//˫�����
public class MyQueue extends MyLinkedList {
	//�ڶ�ͷ����
	public void addFirst(Object ele){
		super.addFirst(ele);
	}
	
	//ɾ����ͷԪ��
	public void removeFirst(){
		remove(this.first.ele);
	}
	public void removeLast(){
		remove(this.last.ele);
	}
	//�ڶ�β����
	public void addLast(Object ele){
		super.addLast(ele);
	}
	//��ͷԪ��
	public Object getFirst(){
		return this.first.ele;
	}
	//��βԪ��
	public Object getLast(){
		return this.last.ele;
	}
	
}
