package FileStream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//�ļ��ַ�������
public class FileReaderDemo {
	public static void main(String[] args) throws IOException {
		//1.����Դ
		File src = new File("C:/Users/15626/Desktop/�½��ļ��� (2)/test.txt");
		//2.�����ַ�����������
		FileReader in = new FileReader(src);
		//3.������
		char[] buffer = new char[10];
		int len = -1;
		while((len = in.read(buffer)) != -1){
			String str = new String(buffer,0,len);
			System.out.println(str);
		}
		
		
		//4.�ر���
		in.close();
		
	}
}
