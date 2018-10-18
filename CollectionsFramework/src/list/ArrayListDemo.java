package list;
import java.util.*;
public class ArrayListDemo {
	public static void main(String []args){
		ArrayList<String> a = new ArrayList<String>();
		
		//增
		a.add("A");
		a.add("B");
		a.add("CC");
		a.add("DDD");
		System.out.println(a);
		
		//删
		a.remove(0);
		System.out.println(a);
		a.remove("DDD");
		System.out.println(a);
		
		//改
		a.set(0, "改");
		System.out.println(a);
		
		//查
		System.out.println(a.size());
	}
}
