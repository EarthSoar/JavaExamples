package FileStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//�ļ��ַ������
public class FileWriterDemo {
	public static void main(String[] args) throws IOException {
		//1.����Ŀ��
		File dest = new File("C:/Users/15626/Desktop/�½��ļ��� (2)/test.txt");
		//2.�������������
		FileWriter out = new FileWriter(dest);
		//3.д����
//		void write(char[] cbuf, int off, int len) д���ַ������ĳһ���֡�          
//	    void write(int c)  д�뵥���ַ���  
//	    void write(String str, int off, int len) д���ַ�����ĳһ���֡� 
		
		//out.write(65);
		//out.write("ABC".toCharArray());//�ַ����������char���飬���Բ���toCharArray
		out.write("ABDASLDK", 0, 5);
		//�ر���
		//out.flush();
		//�ر�ǰ����flush����ˢ�»���
		out.close();
		
	         

	}
}
