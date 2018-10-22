package FileStream;

import java.io.File;
import java.io.FileOutputStream;

public class FileOutputStreamDemo {
	public static void main(String[] args) throws Exception {
		//1.����Դ
		File f = new File("C:/Users/15626/Desktop/test/123.txt");
		//2.�������������
		FileOutputStream out = new FileOutputStream(f);
		//3.д����
		
		/*
		 *  1.void write(byte[] b) 
		          �� b.length ���ֽڴ�ָ�� byte ����д����ļ�������С� 
		 	2.void write(byte[] b, int off, int len) 
		          ��ָ�� byte �����д�ƫ���� off ��ʼ�� len ���ֽ�д����ļ�������� 
		 	3.void write(int b) 
		          ��ָ���ֽ�д����ļ�������� 
		 */
		//out.write(97);//ֻ��һ��һ����д
		
		//��buffer�����е�����д���ļ���
		byte[] buffer = "ABCDEF".getBytes();
		//out.write(buffer);
		
		//������1��ʼ��3���ֽ�д���ļ���
		out.write(buffer, 1, 3);
		
		//4.�ر���Դ
		out.close();
	}
}
