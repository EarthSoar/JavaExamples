package Stack;

import Aarray.MyArrayList;

//����������ʵ��ջ�ṹ:
	//�涨: ���һ��λ����ջ��.
	//����Ϊ0��λ�þ���ջ��.

public class MyStack extends MyArrayList {
	//ѹ��ջ
	public void  push(Object ele){
		super.add(ele);
	}
	
	//��ջ
	public void pop(){
		int index = super.size() - 1;
		super.delete(index);
	}
	
	//��ѯջ��Ԫ��
	public Object peek(){
		int index = super.size() - 1;
		return get(index);
	}
}
