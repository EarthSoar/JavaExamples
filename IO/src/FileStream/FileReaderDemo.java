package FileStream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//文件字符输入流
public class FileReaderDemo {
	public static void main(String[] args) throws IOException {
		//1.创建源
		File src = new File("C:/Users/15626/Desktop/新建文件夹 (2)/test.txt");
		//2.创建字符输入流对象
		FileReader in = new FileReader(src);
		//3.读操作
		char[] buffer = new char[10];
		int len = -1;
		while((len = in.read(buffer)) != -1){
			String str = new String(buffer,0,len);
			System.out.println(str);
		}
		
		
		//4.关闭流
		in.close();
		
	}
}
