package method;


import java.lang.reflect.Method;

/**
 *	用反射机制获取类中的方法
 *	public Method[] getMethods():获取包括自身和继承过来的所有的public方法
	public Method[] getDeclaredMethods():获取自身类中所有的方法(不包括继承的,和访问权限无关)
	
	public Method getMethod(String methodName, Class<?>... parameterTypes):
	表示调用指定的一个公共的方法(包括继承的)
 */
@SuppressWarnings("unused")
class Person{
	public void doWork(){}
	public String doWork(String name){
		return name;
	}
	private void eat(){}
}
public class GetMethodDemo {
	public static void main(String[] args) throws Exception {
		//getAll();//获取所有方法
		getOne();//获取其中的一个方法
	}
	public static void getOne() throws Exception {
		//获取类的字节码对象
		Class<Person> clz = Person.class;
		Method[] me = clz.getMethods();//表示调用指定的一个公共的方法(包括继承的)
		for (Method method : me) {
			System.out.println(method);
		}
		System.out.println("============");
		me = clz.getDeclaredMethods();//获取自身类中所有的方法(不包括继承的,和访问权限无关)
		for (Method method : me) {
			System.out.println(method);
		}
	}
	public static void getAll() throws Exception {
		//获取类的字节码对象
		Class<Person> clz = Person.class;
		//获取doWork()方法
		Method m =clz.getMethod("doWork");
		System.out.println(m);
		System.out.println("============");
		m = clz.getMethod("doWork", String.class);
		System.out.println(m);
		System.out.println("============");
		m = clz.getDeclaredMethod("eat");//设置方法可执行
		System.out.println(m);
	}
}
