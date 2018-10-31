package constructor;

import java.lang.reflect.Constructor;

/**
 *	使用获取的构造器创建对象
 */
class People{
	public People(){
		System.out.println("无参数构造方法");
	}
	public People(String name,int age){
		System.out.println(name + "," + age);
	}
	@SuppressWarnings("unused")
	private People(String name){
		System.out.println(name);
	}
}
public class CreateObjectDemo {
	public static void main(String[] args) throws Exception {
		//获取People类的字节码对象
		Class<People> clz = People.class;
		Constructor<?> con = clz.getConstructor();
		con.newInstance();
		System.out.println("===============");
		
		con = clz.getConstructor(String.class,int.class);
		con.newInstance("XXX",17);
	
		con = clz.getDeclaredConstructor(String.class);
		con.setAccessible(true);//设置当前构造器可访问，这是Constructor的父类AccessibleObject中方法
		con.newInstance("OOO");
	}
}
