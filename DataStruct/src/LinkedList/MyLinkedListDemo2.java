
//˫������
class MyLinkedList {
	private  Node first;//�����е�ͷ���
	private  Node last;//���������һ���ڵ�
	private  int size;//�����нڵ�ĸ���
	//�����е�һ���ڵ�
	public class Node
	{
		Node prev; //ǰһ���ڵ�
		Node next; //��һ���ڵ�
		Object ele; //�洢������Ԫ��
		public Node(Object ele){
			this.ele = ele;
		}
	}

	//���ͷ���һ��Ԫ��
	public void addFirst(Object ele){
		Node node = new Node(ele);
		if(size == 0){//�����нڵ����Ϊ0����ô����ӵĽڵ����ͷ���Ҳ��Ϊβ�ڵ�
			this.first = node;
			this.last = node;
		}else{
			//���ͷ����һ���½ڵ�
			node.next = this.first;
			this.first.prev = node;
			this.first = node;
		}
		size++;
	}
	//���β����һ��Ԫ��
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
	//���������е�һ��Ԫ��
	public Object getFirst(){
		return this.first.ele;
	}
	//���������е����һ��Ԫ��
	public Object getLast(){
		return this.last.ele;
	}
	//ɾ�������еĵ�һ���ڵ�
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
	//ɾ�������е�ָ��Ԫ��
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
	//����toString����,��ʽ����ӡ
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