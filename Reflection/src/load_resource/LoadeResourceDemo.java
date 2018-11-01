package load_resource;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 *	加载资源文件 db.properties文件,只能使用Properties类的load方法.
 */
public class LoadeResourceDemo {
	public static void main(String[] args) throws Exception {
		//test1();//使用绝对路径加载,可以加载到bin目录中
		
		//test2();//使用相对于classpath根路径加载，用到ClassLoader类加载器加载
		
		test3();//相对于当前文件的字节码路径加载
	}
	public static void test1() throws Exception{
		Properties p = new Properties();
		InputStream inStream = new FileInputStream("resource/db.properties");
		p.load(inStream);
		System.out.println(p);
		test1();
	}
	public static void test2() throws Exception{
		/**
		 * 这里有两种方式获得类加载器对象
		 * 1.Class类中有方法getClassLoader()可以返回一个类加载器对象
		 * 2.Thread类中有方法getContextLoader()也可以返回一个类加载器对象
		 */
		Properties p = new Properties();
		//ClassLoader loader = LoadeResourceDemo.class.getClassLoader();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream inStream = loader.getResourceAsStream("db.properties");//返回读取指定资源的输入流
		p.load(inStream);//记载资源文件
		System.out.println(p);
	}
	public static void test3() throws Exception{
		Properties p = new Properties();
		InputStream inStream = LoadeResourceDemo.class.getResourceAsStream("db.properties");
		p.load(inStream);
		System.out.println(p);
	}
	
}
