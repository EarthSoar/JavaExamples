package util;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 15626
 *	集合的工具类 ：Arrays,可以把数组转换成集合
 */
public class ArraysDemo {
	public static void main(String []args){
		//把集合转换成数组
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
		
		//把数组转化成集合
		String [] str = new String[]{"A","b","C"};
		
		//返回的是不能改变长度的list对象，因为返回的ArrayList不是java.util.ArrayList包中的对象，而是Arrays类中的内部类对象
		List<String> list2 = Arrays.asList(str);
		//list2.remove(0);//UnsupportedOperationExceptions
		System.out.println(list2);
		
		//基本类型的数据会自动装箱转化为包装类型，这里的1,2，3都自动装箱为Integer类型
		List<Integer> list3 = Arrays.asList(1,2,3,4,5);
		System.out.println(list3);
		
		//试图把数组直接转化一下,这是直接把数组当做对象，基本类型的数据不能存储到集合中
		int [] a = new int[]{1,2,3,4,5};
		List<int[]> list4 = Arrays.asList(a);
		System.out.println(list4);
	}
}
