package method;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *	使用反射调用数组可变参数，可变参数本质上就是数组
 *	Method对象.invoke(方法所属对象,new Object[]{所有的实参});
 */
class Test{
	//基本类型可变参数
	public void doWork(int...arr){
		System.out.println("doWork方法被调用," + Arrays.toString(arr));
	}
	//引用类型可变参数
	public static void doWork2(String...arr){
		System.out.println("doWork2方法被调用," + Arrays.toString(arr));
	}
}
public class MethodArrayInvokeDemo {
	public static void main(String[] args) throws Exception {
		//获取类的字节码对象
		Class<Test> clz = Test.class;
	
		//基本类型的数组调用，第二个实参传的可以是新建一个int类型的数组。也可以用Object数组进行包装
		Method m = clz.getMethod("doWork", int[].class);
	//	m.invoke(clz.newInstance(), new int[]{1,2,3});
		m.invoke(clz.newInstance(), new Object[]{new int[]{1,2,3,3}});
		
		//引用类型的方法调用，第二个实参只能放在Objec类型的数组中
		m = clz.getMethod("doWork2", String[].class);
		m = clz.getMethod("doWork2", String[].class);
		//m.invoke(clz.newInstance(), new String[]{"A","B"});//错误的写法
		m.invoke(clz.newInstance(), new Object[]{new String[]{"A","B"}});
		
	}
}
