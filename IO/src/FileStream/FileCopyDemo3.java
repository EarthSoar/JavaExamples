package FileStream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//���ļ��ַ�������ļ��Ŀ�����һ���Ǵ��ı��ļ����ַ���
public class FileCopyDemo3 {
	public static void main(String[] args) throws IOException {
		File srcFile = new File("C:/Users/15626/Desktop/�½��ļ��� (2)/test.txt");
		File destFile = new File("C:/Users/15626/Desktop/�½��ļ��� (2)/test_copy.txt");
		
		FileReader in = new FileReader(srcFile);
		FileWriter out = new FileWriter(destFile);
		
		char[] buffer = new char[10];
		int len = -1;
		while((len = in.read(buffer)) != -1){
			out.write(buffer, 0, len);
		}
		
		in.close();
		out.close();
		
	}
}
