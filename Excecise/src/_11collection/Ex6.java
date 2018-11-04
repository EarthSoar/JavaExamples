package _11collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class A{}
class B extends A{}
class C extends A{}
class D extends A{}
public class Ex6 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		Collections.addAll(list,"hello","nihao","love","love","you");
		System.out.println(list);
		list.add("love");
		System.out.println(list);
		System.out.println(list.contains("love"));//true
		System.out.println(list.indexOf("love"));//2
		System.out.println(list.remove("love"));//true
		
		List<Integer> list2 = new ArrayList<>();
		Collections.addAll(list2, 1,2,3,4,5,3);
		Integer i = new Integer(3);
		list2.add(i);
		System.out.println(list2.indexOf(3));
		
		
		List<A> list3 = new ArrayList<>();
		Collections.addAll(list3, new B(),new C(),new B(),new D());
		System.out.println(list3.indexOf(new B()));//false
		
	}
}
