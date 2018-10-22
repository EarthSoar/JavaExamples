package FileStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author 15626
 *	����һ���ļ�
 */
public class FileCopyDemo {
	public static void main(String[] args) throws Exception {
		//1.����Դ��Ŀ��
		File srcFile = new File("C:/Users/15626/Desktop/test/123.txt");
		File targetFile = new File("C:/Users/15626/Desktop/test/123_copy.txt");
		//2.�����������������
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(targetFile);
		//3.���� �������
		byte[] buffer = new byte[10];	
		int len = 0;
		while((len = in.read(buffer)) != -1){
			//String str = new String(buffer,0,len);
			out.write(buffer, 0, len);;
		}		
		//4.�ر���Դ�ļ�
		in.close();
		out.close();
	}
}
