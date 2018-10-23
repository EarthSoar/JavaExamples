package buffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author 15626
 *	�����ַ������ֽ�����Ӧ���û�������װ���������ڱȽ�һ���û������Ͳ��û����������д������һ���ļ�������ʱ��
 *	���ȵıȽ�
 */
public class BufferCompare {
	public static void main(String[] args) throws Exception {
		File srcFile = new File("C:/Users/15626/Desktop/File/��ѧ��_��ս����Ա_1573��1.0��.pdf");
		File destFile = new File("C:/Users/15626/Desktop/File/copy.pdf");
		//test1(srcFile,destFile);//���û�������װ       
		test2(srcFile,destFile);//�û�������װ       
	}
	//ʹ�û�����,���ڴ�ÿ�ζ�ȡ1024���ֽڣ�15ms
	public static void test2(File srcFile, File destFile) throws Exception {
		long begin = System.currentTimeMillis();
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destFile));
	
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = in.read(buffer)) != -1){
			out.write(buffer, 0, len);
		}
		in.close();
		out.close();
		System.out.print(System.currentTimeMillis() - begin);
	}

	//ʹ���ֽ������Ӵ�����ÿ�ζ�ȡ1024���ֽڣ�38ms
	public static void test1(File srcFile,File destFile) throws Exception {
		long begin = System.currentTimeMillis();
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = in.read(buffer)) != -1){
			out.write(buffer, 0, len);
		}
		in.close();
		out.close();
		System.out.print(System.currentTimeMillis() - begin);
	}
}
