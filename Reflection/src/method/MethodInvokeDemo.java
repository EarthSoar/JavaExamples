package method;

import java.lang.reflect.Method;

/**
 * @author 15626
 *	使用反射调用方法
 *	 Object invoke(Object obj, Object... args) 
          对带有指定参数的指定对象调用由此 Method 对象表示的底层方法。 
          
    对于static方法，静态方法属于类本身，此时的invoke方法的参数就是incoike(null,Object... args),也就是不需要对象
 */
class People{
	public void doWork(){
		System.out.println("我是无参数的doWork");
	}
	public String doWork(String name){
		System.out.println("我是带参数的doWork");
		return name;
	}
	@SuppressWarnings("unused")
	private void eat(){
		System.out.println("我是eat方法");
	}
}
public class MethodInvokeDemo {
	public static void main(String[] args) throws Exception {
		//获取类的字节码对象
		Class<People> clz = People.class;
		Method m =clz.getMethod("doWork");
		m.invoke(clz.newInstance());
		
		System.out.println("============");
		
		m = clz.getMethod("doWork", String.class);
		Object o = m.invoke(clz.newInstance(), "xxx");
		System.out.println(o);
		
		m = clz.getDeclaredMethod("eat");
		m.setAccessible(true);//设置方法可执行
		People p = clz.newInstance();
		m.invoke(p);
	}
}
