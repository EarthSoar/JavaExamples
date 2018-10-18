package iterator;
import java.util.*;

//�о�for-each
//for(�������� ������:������/Iterable��ʵ��)
public class ForeachDemo {
	public static void main(String []args){
		int []arr = new int[]{1,2,3,4};
		//for-each���Բ������飬�ײ���Ȼ����forѭ����������������ȡ����Ԫ��
		for(int i:arr){
			System.out.println(i);
		}
		
		//for-eachҲ���� ���� Iterable��ʵ�����ײ���õ���Iterator������
		
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		for(Object ele : list){
			System.out.println(ele);
		}
		System.out.println("------------");
		//������һ�ߵ���һ��ɾ����ʱ�򣬲���ʹ�ü��϶������remove��Ҫʹ�õ������������
		
		//��ʹ�ü��϶������ʱ�򣬻ᱨ�쳣ConcurrentModificationException
		/*
		for(Object ele : list){
			if("2".equals(ele)){
				list.remove(ele);
			}
			System.out.println(ele);
		}
		*/
		
		//��ȷ�Ĳ����ǲ��õ������������remove����
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			Object ele = it.next();
			if("2".equals(ele)){
				it.remove();
			}
		}
		System.out.println(list);
		
		
	}
}
