package _11collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

//����������װһ��List<Integer> ,Ȼ�󴴽��ڶ���������ͬ�ߴ��List<Integer> ,ʹ��ListIterator��ȡ��һ��list�е�
//Ԫ�أ�Ȼ���ٽ������Է�����뵽�ڶ����б���
public class Ex12 {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		Collections.addAll(list1, 1,2,3,2,2,2);
		List<Integer> list2 = new ArrayList<>(list1.size());
		ListIterator<Integer> it1 = list1.listIterator(list1.size());
		while(it1.hasPrevious()){
			list2.add(it1.previous());
		}
		System.out.println(list1);
		System.out.println(list2);
	}
}
