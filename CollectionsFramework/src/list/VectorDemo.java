package list;

import java.util.*;

public class VectorDemo {
	public static void main(String []args){
//		Vector v1 = new Vector();
//		//增
//		v1.add("AA");//11会自动装箱转换为对象
//		v1.add(22);
//		v1.addElement(33);//addElement和add底层是一样的
//		System.out.println(v1);
		
//		Vector v2 = new Vector();
//		StringBuilder sb = new StringBuilder("SSSS");
//		v2.add(sb);//集合类中存储的对象，存储的是对象的引用，并不是存储的值
//		System.out.println(v2);//SSSS
//		sb.append(222);
//		System.out.println(v2);//SSSS222
		
		//v2.addAll(v1);         //addAll把集合v1中的元素增添到集合v2中
		//System.out.println(v2);  //[SSSS222, 11, 22, 33]
//		v2.add(v1);              //v1也是Object类型的,那么就把v1当做整体插入v2集合中
//		System.out.println(v2);  //[SSSS222, [11, 22, 33]]
		
		
		//删
//		v1.remove(2);       //删除指定索引的值
//		System.out.println(v1);
//		
//		v1.remove("AA");   //删除指定元素的第一个匹配项
//		System.out.println(v1);
		
		//改
		Vector<String> v3 = new Vector<String>();
		v3.add("aaa");
		v3.add("bbb");
		v3.add("ccc");
		v3.add("ddd");
		System.out.println(v3);	//[aaa, bbb, ccc, ddd]
		v3.set(0, "mmm");    //修改指定索引的值，另外还返回所修改的值
	   //	Object o = v3.set(1, "111");   //o的值为bbb
		System.out.println(v3); //[mmm, bbb, ccc, ddd]
	
		//查
		System.out.println(v3.size()); //4
		System.out.println(v3.get(2)); //c
	}
}
