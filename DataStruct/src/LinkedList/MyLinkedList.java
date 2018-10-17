package LinkedList;
//˫������
public class MyLinkedList {
	protected Node first;//����ĵ�һ���ڵ�
	protected Node last;//��������һ���ڵ�
	private int size;//������Ԫ�صĸ���
//	public MyLinedList(){
//		this.first = first;
//		this.last = last;
//	}
	//����toString��������ʽ����ӡ��ǰ�����е�Ԫ��
	public String toString(){
		if(size == 0){
			return("[]");
		} 
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node current = this.first;//�ѵ�ǰ��һ���ڵ���ΪĬ��ֵ
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
	//������ͷ������һ��Ԫ��
	public void addFirst(Object ele){
		Node node = new Node(ele);
		if(size == 0){
			this.first = node;
			this.last = node;
		}else{
			//��֮ǰ�ĵ�һ���ڵ���Ϊ�����ڵ����һ��
			node.next = this.first;
			//�������ڵ���Ϊ֮���һ���ڵ����һ���ڵ�
			this.first.prev = node;
			//�������ڵ���Ϊ��һ���ڵ�
			this.first = node;
		}
		size++;
	}
	
	//�������β����һ��Ԫ��
	public void addLast(Object ele){
		Node node = new Node(ele);
		if(size == 0){//�ж��������Ƿ�Ϊ�գ���Ϊ�գ���ô��ǰ�ڵ���ǵ�һ���ڵ㣬Ҳ�����һ���ڵ�
			this.first = node;
			this.last = node;
		}else{
			//��֮ǰ�����һ���ڵ���Ϊ�����ڵ��prev
			node.prev = this.last;
			//�������ڵ���Ϊ֮ǰ���һ���ڵ��next
			this.last.next = node;
			//�������ڵ���Ϊ���һ���ڵ�
			this.last = node;
		}
		size++;
	}
/*
	//���������е�Ԫ��
	public Object getEle(Object ele){
		Node current = this.first;//�ӵ�һ���ڵ㿪ʼ����
		for(int i = 0;i < size; i++){
			if(!current.ele.equals(ele)){ //�ж�Ԫ���Ƿ���ͬ
				if(current.next == null){//ֱ����һ����null˵��û�ҵ���Ԫ��,���������
					return "null";
				}
				current = current.next;//����������
			}
		}
		return current.ele;
	}
*/
/*	
	//ɾ�������еĵ�һ��Ԫ��
	public void removeFirst(){
		//Node current = this.first;//�ӵ�һ���ڵ㿪ʼ����
		this.first = this.first.next;//����Ҫɾ���Ľڵ����һ���ڵ��Ϊ��һ���ڵ�
		this.first.prev = null;//���µĵ�һ���ڵ��prev��Ϊnull
	}
	//ɾ�������е����һ��Ԫ��
	public void removeLast(){
		//Node current = this.last;
		this.last = this.last.prev;
		this.last.next = null;
	}
*/
	//ɾ�������е�һ��Ԫ��
	public void remove(Object ele) {
		//���ҵ���Ҫɾ���Ľڵ�
		Node current = this.first;//�ӵ�һ���ڵ㿪ʼ����
		for(int i = 0;i < size; i++){
			if(!current.ele.equals(ele)){ //�ж�Ԫ���Ƿ���ͬ
				if(current.next == null){//ֱ����һ����null˵��û�ҵ���Ԫ��,���������
					return;
				}
				current = current.next;//����������
			}
		}
		//ѭ����ɺ�  current.ele == ele;˵���ҵ������Ԫ��
		
		
		//��Ҫɾ����Ԫ���ǵ�һ���ڵ㡢���һ���ڵ㡢�м�һ���ڵ�
		if(current == this.first){
			this.first = current.next;//����Ҫɾ���Ľڵ����һ���ڵ��Ϊ��һ���ڵ�
			this.first.prev = null;//���µĵ�һ���ڵ��prev��Ϊnull
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
		Node prev;//��һ���ڵ�
		Node next;//��һ���ڵ�
		public Object ele;//����Ԫ��
	}

}
