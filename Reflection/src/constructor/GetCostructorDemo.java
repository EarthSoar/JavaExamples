package constructor;

import java.lang.reflect.Constructor;

/**
 *	ͨ�������ȡһ����Ĺ�����
 *  Constructor<?>[] getConstructors()  
 *  ����һ������ĳЩ Constructor ��������飬��Щ����ӳ�� Class ��������ʾ��������й������췽����
 *  Constructor<?>[] getDeclaredConstructors()  �������еĹ��췽����û��Ȩ������
 * 	
 */
class Person{
	public Person(){}
	public Person(String name,int age){}
	@SuppressWarnings("unused")
	private Person(String name){}
}
public class GetCostructorDemo {
	public static void main(String[] args) throws Exception {
		//getAll();//��ȡ���е�ȫ��������
		getOne();//��ȡ���е�һ��������
	}
	public static void getOne() throws Exception{
		//��ȡ����ֽ������
		Class<Person> clz = Person.class;
		//����һ����ȡ������
		Constructor<?> con = clz.getConstructor();//�޲���������
		System.out.println(con);
		System.out.println("=============");
		con = clz.getConstructor(String.class,int.class);//����String�Ĺ�����
		System.out.println(con);
		System.out.println("=============");
		con = clz.getDeclaredConstructor(String.class);//��ȡ��private���εĹ�����
		System.out.println(con);
	}
	public static void getAll() throws Exception {
		//��ȡ����ֽ������
		Class<Person> clz = Person.class;
		//�������л�ȡ�������ķ���
		Constructor<?>[] con = clz.getConstructors();
		for (Constructor<?> constructor : con) {
			System.out.println(constructor);
		}
		System.out.println("=============");
		con = clz.getDeclaredConstructors();
		for (Constructor<?> constructor : con) {
			System.out.println(constructor);
		}
	}

	
}
