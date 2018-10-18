package iterator;
import java.util.*;

//研究for-each
//for(变量类型 变量名:数组名/Iterable的实例)
public class ForeachDemo {
	public static void main(String []args){
		int []arr = new int[]{1,2,3,4};
		//for-each可以操作数组，底层依然采用for循环和数组索引来获取数组元素
		for(int i:arr){
			System.out.println(i);
		}
		
		//for-each也可以 操作 Iterable的实例：底层采用的是Iterator迭代器
		
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		for(Object ele : list){
			System.out.println(ele);
		}
		System.out.println("------------");
		//当集合一边迭代一边删除的时候，不能使用集合对象调用remove，要使用迭代器对象调用
		
		//当使用集合对象调用时候，会报异常ConcurrentModificationException
		/*
		for(Object ele : list){
			if("2".equals(ele)){
				list.remove(ele);
			}
			System.out.println(ele);
		}
		*/
		
		//正确的操作是采用迭代器对象调用remove方法
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
