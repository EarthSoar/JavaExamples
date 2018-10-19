package set;
import java.util.*;
/**
 * @author 15626
 *	TreeSet 底层采用的是是红黑树算法，会对存储的 元素进行自然排序(从小到大)
 *	要排序当然要保证类型相同，可以使用泛型进行规范
 *	排序规则：数字就进行比大小，字符就按照Unicode编码规范来比较（前128位与ASCII编码重复）
 */
public class TreeSetDemo {

	public static void main(String []args){
		Set<Student> set = new TreeSet<Student>();
		set.add(new Student("张三",30));
		set.add(new Student("李四",20));
		set.add(new Student("王麻子",10));
		System.out.println(set);
		
		
		/**
		 * 定制排序：在TreeSet构造器中传一个实现Comparator接口类的一个对象，
		 * 在实现类中覆盖Comparator接口中的public int compare(Ojbect o1,Object o2)方法
		 * 在方法中可以编写比较规则 
		 */
		
		//定制排序：根据人名长度进行排序
		Set<Student> set2 = new TreeSet<Student>(new NameLengthComparator());
		set2.add(new Student("张三李四",30));
		set2.add(new Student("李四",20));
		set2.add(new Student("王麻子",10));
		System.out.println(set2);
	}
}
class NameLengthComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		if(o1.name.length()>o2.name.length()){
			return 1;
		}else if(o1.name.length() < o2.name.length()){
			return -1;
		}else{
			return 0;    //说明是同一个对象
		}
	}
	
}
class Student implements Comparable<Student>{
	String name;
	int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	/* 自然排序：覆盖Comparable接口中的compareTo方法
	 * this > o ,返回正整数
	 * this < o ,返回负整数
	 * this = o ,返回0     //说明两个对象相同
	 * 
	 */

	@Override
	//自然排序：根据年龄排序
	
	public int compareTo(Student o) {
		if(this.age > o.age){
			return 1;      
		}else if(this.age < o.age){
			return -1;
		}
		return 0;
	}
}