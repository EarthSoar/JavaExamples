package FileStream;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

@SuppressWarnings("unused")
public class FileInputStreamDemo {
	public static void main(String[]args) throws Exception{
		//1.创建源
		File f = new File("C:/Users/15626/Desktop/test/111.txt");
		//2.创建文件输入流对象
		FileInputStream in = new FileInputStream(f);
		//3.读操作
		/*
		 *  int read() 	从此输入流中读取一个数据字节。 
		 int read(byte[] b) 从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中
		 int read(byte[] b, int off, int len)从此输入流中将最多 len 个字节的数据读入一个 byte 数组中
		 */
		
		//读取文件中所有的数据
		byte[] buffer = new byte[5];//定义一个缓冲数组长度为5，每次只能读取5个字节
		int len = 0;//当前读取的字节数，没有字节就返回 -1
		while((len = in.read(buffer))!= -1 ){
			String str = new String(buffer,0,len);
			System.out.println(str);
		}

		//int data = in.read();//读取一个字节
		//System.out.println(data);		
		
		//byte[] buffer = new byte[5];//定义一个缓冲数组
		//int ret = in.read(buffer);  //把文件中数据读取到byte类型数组中，返回读取数据的长度
		//System.out.println(ret);
		//System.out.println(Arrays.toString(buffer));

		//in.read(buffer, 0, 3);
		//把byte类型数组转换成字符串
		//String str = new String(buffer,0,3);
		//System.out.println(str);
		
		//4.关闭资源
		in.close();
	}
}
