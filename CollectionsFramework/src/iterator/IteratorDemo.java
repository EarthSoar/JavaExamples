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
	
		//取出集合中的元素的方法
		
		//方法1：for循环
		for(int index = 0; index < list.size() ;index++){
			System.out.println(list.get(index));
		}
		System.out.println("===============");
		//方法2：for-each
		//for(类型名称 变量名 ：数组名/Iterable的实例)
		for(Object ob : list){
			System.out.println(ob);
		}
		System.out.println("===============");
		//方法3：使用list接口中的一个方法，返回迭代器Iterator
		Iterator<String> it = list.iterator();
//		System.out.println(it.next());
//		System.out.println(it.next());
		 
		System.out.println("===============");
		while(it.hasNext()){
			 System.out.println(it.next());
		}
		System.out.println("===============");
		
		//方法4：使用for循环来操作迭代器
		for(Iterator<String> it2 = list.iterator();it2.hasNext();){
			System.out.println(it2.next());
		}
		System.out.println("------");
		//方法5：使用古老的迭代器对象Enumeration
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
