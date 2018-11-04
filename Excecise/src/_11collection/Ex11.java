package _11collection;

import java.util.*;

//写一个方法，使用Iterator遍历Collection,并且打印容器中每一个对象的toString()
//填充各种数据类型的Collection，然后对其使用此方法
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
