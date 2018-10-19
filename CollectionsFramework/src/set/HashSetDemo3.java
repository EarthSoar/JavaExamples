package set;

import java.util.*;



class Person{
	private int id;
	private String name;
	private int age;
	public String toString(){
		return "{id:"+id+",+name:"+name+","+"age:"+age+"}";
	}
	public Person(int id,String name,int age){
		this.age = age;
		this.name = name;
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}

/**
 * @author 15626
 *	按住shift+alt+s,点鼠标右键，eclipse可以自动生成equals方法和hashCode方法
 *可以选择根据什么来判断是否一个对象，这里选择是根据id来判断，如果发现id相同，就当做相同的对象
 *对象的hashCode值决定了在哈希表中的存储位置.
 */

/**
 * @author 15626
 *
 *当往HashSet集合中添加新的对象的时候,先回判断该对象和集合对象中的hashCode值:
      1):不等: 直接把该新的对象存储到hashCode指定的位置.
      2):相等: 再继续判断新对象和集合对象中的equals做比较.

 */
public class HashSetDemo3 {
	public static void main(String []args){
		Set<Person> set = new HashSet<>();
		set.add(new Person(6,"张三",19));
		set.add(new Person(1,"太上老君",99));
		set.add(new Person(3,"王五",20));
		System.out.println(set);
		System.out.println(set.size());
	}
}
