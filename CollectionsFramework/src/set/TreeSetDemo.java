package set;
import java.util.*;
/**
 * @author 15626
 *	TreeSet �ײ���õ����Ǻ�����㷨����Դ洢�� Ԫ�ؽ�����Ȼ����(��С����)
 *	Ҫ����ȻҪ��֤������ͬ������ʹ�÷��ͽ��й淶
 *	����������־ͽ��бȴ�С���ַ��Ͱ���Unicode����淶���Ƚϣ�ǰ128λ��ASCII�����ظ���
 */
public class TreeSetDemo {

	public static void main(String []args){
		Set<Student> set = new TreeSet<Student>();
		set.add(new Student("����",30));
		set.add(new Student("����",20));
		set.add(new Student("������",10));
		System.out.println(set);
		
		
		/**
		 * ����������TreeSet�������д�һ��ʵ��Comparator�ӿ����һ������
		 * ��ʵ�����и���Comparator�ӿ��е�public int compare(Ojbect o1,Object o2)����
		 * �ڷ����п��Ա�д�ȽϹ��� 
		 */
		
		//�������򣺸����������Ƚ�������
		Set<Student> set2 = new TreeSet<Student>(new NameLengthComparator());
		set2.add(new Student("��������",30));
		set2.add(new Student("����",20));
		set2.add(new Student("������",10));
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
			return 0;    //˵����ͬһ������
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

	/* ��Ȼ���򣺸���Comparable�ӿ��е�compareTo����
	 * this > o ,����������
	 * this < o ,���ظ�����
	 * this = o ,����0     //˵������������ͬ
	 * 
	 */

	@Override
	//��Ȼ���򣺸�����������
	
	public int compareTo(Student o) {
		if(this.age > o.age){
			return 1;      
		}else if(this.age < o.age){
			return -1;
		}
		return 0;
	}
}