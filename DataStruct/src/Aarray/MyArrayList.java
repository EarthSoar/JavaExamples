package Aarray;

import java.util.Arrays;

public class MyArrayList {
	//�洢��������Ԫ��
		private  Object[] elements = null;
		//������Ԫ�صĸ���
		private  int size = 0;
		//��ʼ��Ĭ������
		private static final int DEFAULT_INIT_CAPACITY = 10;
		public MyArrayList(){  //�޲ι�����,���Զ�����������в����Ĺ�����;
			this(DEFAULT_INIT_CAPACITY);
		}
		//������������ʼ������
		public MyArrayList(int initialcapcity) {
			if(initialcapcity < 0){
				throw new IllegalArgumentException("��������Ϊ����");
			}	
			elements = new Object[initialcapcity];
		}
		
		//������Ԫ��
		public  void add(Object eleNum){
			
			if(size == elements.length){   //�����ˣ������Զ�����,���ݻ���Ϊ2��
				Object[] temp = Arrays.copyOf(elements,elements.length*2);
				elements = temp;
			}
				
			elements[size] = eleNum;
			size++;
		}
		
		//��ѯ�ƶ�������Ӧ��ֵ
		public  Object get(int index){
			if(index < 0 || index >= size){//����Խ����
				throw new IllegalArgumentException("����Խ��");
			}
			return elements[index];
		}
		
		//�滻ָ��Ԫ�ص�����ֵ
		public  void set(int index,Object neweleNum) {
			if(index < 0 || index >= size){//����Խ����
				throw new IllegalArgumentException("����Խ��");
			}
			elements[index] = neweleNum;
		}
		//ɾ��ָ��������ֵ
		public  void delete(int index){
			if(index < 0 || index >= size){//����Խ����
				throw new IllegalArgumentException("����Խ��");
			}
			for(int i = index;i < size -1 ;i++){   //size - 1  ��ֹ����Խ�磬��������size-1��Ϊnull
				elements[index] = elements[index + 1];//��index+1���ƶ���index
			}
			//��index ��Ϊnull 
			elements[size - 1] = null ;
			//���鳤�� ��1
			size--;
		}
		
		//��ӡ����
		public String toString(){
			if(elements == null){
				//System.out.println("null");
				return "null";//��������
			}
			if(size == 0){
				//System.out.println("[]");
				return "[]";
			}
			StringBuilder sb = new StringBuilder(size*2 + 1);
			sb.append("[");
			for(int index = 0;index < size ;index++){
				sb.append(elements[index]);
				if(index != size - 1){//�����鲻�����һ��Ԫ��
					sb.append(",");
				}else{
					sb.append("]");
				}
			}
			//System.out.println(sb.toString());
			return sb.toString();
		}
		
		//����Ԫ�صĸ���
		public int size() {
			return size;
		}
		
		//���
		public  void clear(){
			//this.elements = new Object[DEFAULT_INIT_CAPACITY];
			for(int i = 0;i < size; i++)
			{
				elements[i] = null;
			}
			size = 0;
		}
		
		//�ж������Ƿ�Ϊ��
		public boolean isEmplty(){
			return size == 0;
		}

}
