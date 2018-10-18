package iterator;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class IteratorDemo {
	public static void main(String []args){
		ArrayList<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
	
		//ȡ�������е�Ԫ�صķ���
		
		//����1��forѭ��
		for(int index = 0; index < list.size() ;index++){
			System.out.println(list.get(index));
		}
		System.out.println("===============");
		//����2��for-each
		//for(�������� ������ ��������/Iterable��ʵ��)
		for(Object ob : list){
			System.out.println(ob);
		}
		System.out.println("===============");
		//����3��ʹ��list�ӿ��е�һ�����������ص�����Iterator
		Iterator<String> it = list.iterator();
//		System.out.println(it.next());
//		System.out.println(it.next());
		 
		System.out.println("===============");
		while(it.hasNext()){
			 System.out.println(it.next());
		}
		System.out.println("===============");
		
		//����4��ʹ��forѭ��������������
		for(Iterator<String> it2 = list.iterator();it2.hasNext();){
			System.out.println(it2.next());
		}
		System.out.println("------");
		//����5��ʹ�ù��ϵĵ���������Enumeration
		Vector<String> v1 = new Vector<String>();
		v1.add("A");
		v1.add("B");
		v1.add("C");
		v1.add("D");
		v1.add("E");
		Enumeration<String> en = v1.elements();
		while(en.hasMoreElements()){
			System.out.println(en.nextElement());
		}
	}
}
