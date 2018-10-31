package constructor;

import java.lang.reflect.Constructor;

/**
 *	通过反射获取一个类的构造器
 *  Constructor<?>[] getConstructors()  
 *  返回一个包含某些 Constructor 对象的数组，这些对象反映此 Class 对象所表示的类的所有公共构造方法。
 *  Constructor<?>[] getDeclaredConstructors()  返回所有的构造方法，没有权限限制
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
		//getAll();//获取类中的全部构造器
		getOne();//获取类中的一个构造器
	}
	public static void getOne() throws Exception{
		//获取类的字节码对象
		Class<Person> clz = Person.class;
		//调用一个获取构造器
		Constructor<?> con = clz.getConstructor();//无参数构造器
		System.out.println(con);
		System.out.println("=============");
		con = clz.getConstructor(String.class,int.class);//带有String的构造器
		System.out.println(con);
		System.out.println("=============");
		con = clz.getDeclaredConstructor(String.class);//获取第private修饰的构造器
		System.out.println(con);
	}
	public static void getAll() throws Exception {
		//获取类的字节码对象
		Class<Person> clz = Person.class;
		//调用所有获取构造器的方法
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
