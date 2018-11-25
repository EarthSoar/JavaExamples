package LinkedList;

public class MySingleLinkedList {
	Node first;// ͷ���
	int size = 0;

	// 1.ͷ����
	public void addFirst(Object ele) {
		Node node = new Node(ele);
		if (size == 0) {
			this.first = node;
		} else {
			node.next = this.first;
			this.first = node;
		}
		size++;
	}

	// 2.β����
	public void addLast(Object ele) {
		Node node = new Node(ele);
		if (size == 0) {
			this.first = node;
		}
		for (Node current = this.first;; current = current.next) {
			if (current.next == null) {
				current.next = node;
				break;
			}
		}
		size++;
	} 

	// ɾ��Ԫ��
	public void remove(Object ele) {
		Node preNode = null;
		for(Node current = this.first;current != null;current = current.next){
			//��һ��Ԫ��
			if(ele.equals(this.first.ele)){
				removeFirst();
				return;
			}
			//�ҵ��˸�Ԫ��
			if(current.ele.equals(ele)){
				preNode.next = current.next;
				current.next = null;
			}
			preNode = current;
		}
		size--;
	}
    public void delteVal(Object ele) {
    	Node current = this.first.next;
    	Node preNode = this.first;
    	while(current != null){
    		if(current.ele.equals(ele)){
    			preNode.next = current.next;
    			current = preNode.next;
    			size--;
    		}else{
    			preNode = current;
    			current = current.next;
    		}
    	}
    }
	public void removeFirst(){
		this.first = this.first.next;
		size--;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder(40);
		if (size == 0) {
			sb.append("[]");
		}
		sb.append("[");
		Node current = this.first;
		for (int i = 0; i < size; i++) {
			sb.append(current.ele);
			if (i != size - 1) {
				sb.append(",");
			} else {
				sb.append("]");
			}
			current = current.next;
		}
		return sb.toString();
	}

	public class Node {
		Node next;
		Object ele;

		public Node(Object ele) {
			this.ele = ele;
		}
	}
}
