package class_instance;

/**
 *	获取一个Class对象
 *	
 *	方式一：使用class属性（所有的数据类型都具有）
 *	方式二：使用对象的getClass()    该方法是Object类中的，说明是任意类型的对象都可调用
 *	方式三：Class类中的静态方法forName(String className),className是类的权限定名称
 */
public class ClassInstanceDemo {
	public static void main(String[] args) throws Exception {
		//方式一
		Class<java.util.Date> clz1 = java.util.Date.class;
		//方式二
		java.util.Date data = new java.util.Date();
		Class<?> clz2 = data.getClass();
		//方式三
		Class<?> clz3 = Class.forName("java.util.Date");
		
		System.out.println(clz1);//Class类中覆盖了toString方法,里面直接可以写对象的名称
		System.out.println(clz2);//Class类中覆盖了toString方法,里面直接可以写对象的名称
		System.out.println(clz3);//Class类中覆盖了toString方法,里面直接可以写对象的名称
		
		System.out.println(clz1 == clz2);//在同一个类中，JVM中只存在一个字节码对象
	}
}
