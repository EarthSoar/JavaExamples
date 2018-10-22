package FileStream;

import java.io.File;
import java.io.FileOutputStream;

public class FileOutputStreamDemo {
	public static void main(String[] args) throws Exception {
		//1.创建源
		File f = new File("C:/Users/15626/Desktop/test/123.txt");
		//2.创建输出流对象
		FileOutputStream out = new FileOutputStream(f);
		//3.写操作
		
		/*
		 *  1.void write(byte[] b) 
		          将 b.length 个字节从指定 byte 数组写入此文件输出流中。 
		 	2.void write(byte[] b, int off, int len) 
		          将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流。 
		 	3.void write(int b) 
		          将指定字节写入此文件输出流。 
		 */
		//out.write(97);//只能一个一个的写
		
		//将buffer数组中的数据写在文件中
		byte[] buffer = "ABCDEF".getBytes();
		//out.write(buffer);
		
		//从索引1开始的3个字节写在文件中
		out.write(buffer, 1, 3);
		
		//4.关闭资源
		out.close();
	}
}
