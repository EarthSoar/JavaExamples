package map;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 15626
 *	һ��ѧУ�����а༶�ļ��ϣ��༶��������ѧ������
 */

//����һ��ѧ����
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
		//����Set���ϴ洢һ���༶ѧ������Ϣ
		Set<Student> class1 = new HashSet<>();
		class1.add(new Student("����",18));
		class1.add(new Student("ٻ��",20));		
		class1.add(new Student("����",10));
		//System.out.println(set);
		Set<Student> class2 = new HashSet<>();
		class2.add(new Student("����",18));
		class2.add(new Student("����",20));		
		class2.add(new Student("����",10));
		//ʹ��Map�洢һ��ѧԺ�����
		Map<String,Set<Student>> college1 = new HashMap<>();
		college1.put("��ͭ��", class1);
		college1.put("������", class2);
		//System.out.println(map);
		Map<String,Set<Student>> college2 = new HashMap<>();
		college2.put("�ƽ��", class1);
		college2.put("��ʯ��", class2);
		//��List���ϴ洢һ��ѧУ�Ķ��ѧԺ
		List<Map<String,Set<Student>>> school = new ArrayList<>();
		school.add(college1);
		school.add(college2);
		System.out.println(school);
	}
}
