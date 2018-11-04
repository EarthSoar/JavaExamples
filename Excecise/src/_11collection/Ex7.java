package _11collection;

import java.util.ArrayList;
import java.util.List;

/**
 *创建一个类，然后创建一个用你的类的对象进行过初始化的数组。通过使用subList()方法，创建你的List子集，然后在你的List
 *中删除这个子集
 */
class Test{
//	static int count;
//	int a = count++;
//	public String toString(){
//		return String.valueOf(a);
//	}
	int id;
	Test(int id){
		this.id = id;
	}
	@Override
	public String toString() {
		return id + "";
	}
}
public class Ex7 {
	public static void main(String[] args) {
		Test[] t = new Test[10];
		for(int i = 0; i < t.length; i++){
			t[i] = new Test(i);
		}
		List<Test> list = new ArrayList<>();
		for(Test m : t){
			list.add(m);
		}
		System.out.println(list);
		
		List<Test> sub = list.subList(1, 4);
		System.out.println(sub);
		list.removeAll(sub);
		System.out.println(list);
	} 
}
