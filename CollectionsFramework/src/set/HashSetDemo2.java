package set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 15626
 *	判断元素是否相同需要同时覆盖equals方法和HashCode方法
 *	
 *	演示的确需要同时覆盖，两个方法都得有，缺一不可
 */
class A{
	public int hashCode(Object ob){
		return 0;
	}
}
class B{
	public boolean equals(){
		return true;
	}
}
class C{
	public int hashCode(){
		return 1;
	}
	public boolean equals(Object ob){
		return true;
	}
}
public class HashSetDemo2 {
	public static void main(String []args){
		Set<Object> set = new HashSet<Object>();
		set.add(new A());
		set.add(new A());
		set.add(new B());
		set.add(new B());
		set.add(new C());
		set.add(new C());
		System.out.println(set.size());  //5
	}
}
