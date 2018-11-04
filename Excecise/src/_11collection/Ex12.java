package _11collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

//创建并且组装一个List<Integer> ,然后创建第二个具有相同尺寸的List<Integer> ,使用ListIterator读取第一个list中的
//元素，然后再将它们以反序插入到第二个列表中
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
