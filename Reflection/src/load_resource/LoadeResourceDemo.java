package load_resource;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 *	������Դ�ļ� db.properties�ļ�,ֻ��ʹ��Properties���load����.
 */
public class LoadeResourceDemo {
	public static void main(String[] args) throws Exception {
		//test1();//ʹ�þ���·������,���Լ��ص�binĿ¼��
		
		//test2();//ʹ�������classpath��·�����أ��õ�ClassLoader�����������
		
		test3();//����ڵ�ǰ�ļ����ֽ���·������
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
		 * ���������ַ�ʽ��������������
		 * 1.Class�����з���getClassLoader()���Է���һ�������������
		 * 2.Thread�����з���getContextLoader()Ҳ���Է���һ�������������
		 */
		Properties p = new Properties();
		//ClassLoader loader = LoadeResourceDemo.class.getClassLoader();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream inStream = loader.getResourceAsStream("db.properties");//���ض�ȡָ����Դ��������
		p.load(inStream);//������Դ�ļ�
		System.out.println(p);
	}
	public static void test3() throws Exception{
		Properties p = new Properties();
		InputStream inStream = LoadeResourceDemo.class.getResourceAsStream("db.properties");
		p.load(inStream);
		System.out.println(p);
	}
	
}
