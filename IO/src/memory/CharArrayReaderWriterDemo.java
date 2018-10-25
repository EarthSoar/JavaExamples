package memory;
import java.io.*;
/**
 * @author 15626
 *	字符内存流或者说是字符数组流
 *	字符内存输出流：CharArrayWriter
 *	字符内存输入流：CharArrayReader
 */
public class CharArrayReaderWriterDemo {
	public static void main(String[] args) throws Exception {
		//字符内存输出流 ： 从程序把数据存储到内存中的一个缓冲数组中
		CharArrayWriter cWriter = new CharArrayWriter();
		cWriter.write("你是天边最美的云彩");
		//获取缓冲数组中的内容,用toCharArray()方法获取
		char[] ch= cWriter.toCharArray();
		
		//字符内存输入流：从内存中被数据读取到程序中来
		CharArrayReader sReader = new CharArrayReader(ch);
		char[] buffer = new char[1024];
		int len = -1;
		while((len = sReader.read(buffer)) != -1){
			System.out.println(new String(buffer,0,len));
		}
		
		
		//关闭流无效，因为本身就在存储在内存中
		sReader.close();
		cWriter.close();
	}
}
