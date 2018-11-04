package _11collection;

import java.util.*;

//дһ��������ʹ��Iterator����Collection,���Ҵ�ӡ������ÿһ�������toString()
//�������������͵�Collection��Ȼ�����ʹ�ô˷���
public class Ex11 {
	static <T> void display(Iterator<T> it){
		while(it.hasNext()){
			T t = it.next();
			System.out.print(t);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Set<String> set = new HashSet<>();
		Collections.addAll(list, 1,2,3,2,2,2);
		Collections.addAll(set, "1","2","3");
		display(list.iterator());
		display(set.iterator());
	}
}
