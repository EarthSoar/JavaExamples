package FileStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//文件字符输出流
public class FileWriterDemo {
	public static void main(String[] args) throws IOException {
		//1.创建目的
		File dest = new File("C:/Users/15626/Desktop/新建文件夹 (2)/test.txt");
		//2.创建输出流对象
		FileWriter out = new FileWriter(dest);
		//3.写操作
//		void write(char[] cbuf, int off, int len) 写入字符数组的某一部分。          
//	    void write(int c)  写入单个字符。  
//	    void write(String str, int off, int len) 写入字符串的某一部分。 
		
		//out.write(65);
		//out.write("ABC".toCharArray());//字符串本身就是char数组，可以不用toCharArray
		out.write("ABDASLDK", 0, 5);
		//关闭流
		//out.flush();
		//关闭前调用flush方法刷新缓存
		out.close();
		
	         

	}
}
