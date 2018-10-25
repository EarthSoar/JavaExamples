package properties;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * properties类用来加载资源文件
 * @author 15626
 *
 */
public class LoadResourceDemo {
	public static void main(String[] args) throws Exception {
		//创建类的对象
		Properties p = new Properties();
		//把资源文件加载到文件输入流
		InputStream inStream = new FileInputStream("D:/JavaWork/IO/file/db.properties");
		p.load(inStream);
		System.out.println(p);
		System.out.println(p.getProperty("username"));
	}
}
