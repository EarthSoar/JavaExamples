package util;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 15626
 *	���ϵĹ����� ��Arrays,���԰�����ת���ɼ���
 */
public class ArraysDemo {
	public static void main(String []args){
		//�Ѽ���ת��������
		ArrayList<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("d");
		Object [] arr= list.toArray();
		for(Object arr1 : arr){
			System.out.println(arr1);
		}
		
		System.out.println("========================");
		
		//������ת���ɼ���
		String [] str = new String[]{"A","b","C"};
		
		//���ص��ǲ��ܸı䳤�ȵ�list������Ϊ���ص�ArrayList����java.util.ArrayList���еĶ��󣬶���Arrays���е��ڲ������
		List<String> list2 = Arrays.asList(str);
		//list2.remove(0);//UnsupportedOperationExceptions
		System.out.println(list2);
		
		//�������͵����ݻ��Զ�װ��ת��Ϊ��װ���ͣ������1,2��3���Զ�װ��ΪInteger����
		List<Integer> list3 = Arrays.asList(1,2,3,4,5);
		System.out.println(list3);
		
		//��ͼ������ֱ��ת��һ��,����ֱ�Ӱ����鵱�����󣬻������͵����ݲ��ܴ洢��������
		int [] a = new int[]{1,2,3,4,5};
		List<int[]> list4 = Arrays.asList(a);
		System.out.println(list4);
	}
}
