package properties;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * properties������������Դ�ļ�
 * @author 15626
 *
 */
public class LoadResourceDemo {
	public static void main(String[] args) throws Exception {
		//������Ķ���
		Properties p = new Properties();
		//����Դ�ļ����ص��ļ�������
		InputStream inStream = new FileInputStream("D:/JavaWork/IO/file/db.properties");
		p.load(inStream);
		System.out.println(p);
		System.out.println(p.getProperty("username"));
	}
}
