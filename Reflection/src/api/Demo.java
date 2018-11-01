package api;

import java.lang.reflect.Modifier;

/**
 *	Class类的API
 *
 */
public class Demo {
	public static void main(String[] args){
		String name = Demo.class.getName();//getName()返回该类的权限的权限的名称
		System.out.println(name);
		
		String packagename = Demo.class.getPackage().getName();//getPackage()返回该类所在的包名
		System.out.println(packagename);
		
		int mod = Demo.class.getModifiers();//返回该类的修饰符
		String type = Modifier.toString(mod);
		System.out.println(type);
		
		String supername = Demo.class.getSuperclass().getName();//返回父类的名称
		System.out.println(supername);
		
		Object arr = new int[]{1,2,2};//判断该字节码对象是否是数组类，也就是实际类型是不是数组
		System.out.println(arr.getClass().isArray());
	}
}
