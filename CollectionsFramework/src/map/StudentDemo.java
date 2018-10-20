package map;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 15626
 *	一个学校集合中班级的集合，班级集合中有学生集合
 */

//定义一个学生类
class Student{
	private String name;
	private int age;
	public Student(String name,int age){
		this.name = name;
		this.age = age;
	}
	public String getName(){
		return name;
	}
	public void setNme(String name){
		this.name = name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
}

public class StudentDemo {
	public static void main(String []args){
		//定义Set集合存储一个班级学生的信息
		Set<Student> class1 = new HashSet<>();
		class1.add(new Student("赵毅",18));
		class1.add(new Student("倩儿",20));		
		class1.add(new Student("孙三",10));
		//System.out.println(set);
		Set<Student> class2 = new HashSet<>();
		class2.add(new Student("李四",18));
		class2.add(new Student("周五",20));		
		class2.add(new Student("吴六",10));
		//使用Map存储一个学院多个班
		Map<String,Set<Student>> college1 = new HashMap<>();
		college1.put("青铜班", class1);
		college1.put("白银班", class2);
		//System.out.println(map);
		Map<String,Set<Student>> college2 = new HashMap<>();
		college2.put("黄金班", class1);
		college2.put("钻石班", class2);
		//用List集合存储一个学校的多个学院
		List<Map<String,Set<Student>>> school = new ArrayList<>();
		school.add(college1);
		school.add(college2);
		System.out.println(school);
	}
}
