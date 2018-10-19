package set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 15626
 *1、不记录元素添加的顺序；2、不允许元素重复
 */

public class HashSetDemo {
	public static void main(String []args){
		Set<String> set = new HashSet<String>();
		set.add("1mm");
		set.add("aaa");
		set.add("1mm");
		set.add("111");
		set.add("sss");
		
		System.out.println(set);
	}
}