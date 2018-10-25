package memory;
import java.io.*;
/**
 * @author 15626
 *	字符串的内存流，把程序中的数据存储在一个缓冲字符串中
 *	字符串的输出流 ：StringWriter
 *	字符串的输入流：StringReader
 */
public class StringWriterReaderDemo {
	public static void main(String[] args) throws Exception {
		//字符串的输出流
		StringWriter out = new StringWriter();
		out.write("你真的想成为一只帅帅气气的一只小人吗");
		//获取缓冲区的字符串
		//System.out.print(out.toString());
		
		//字符串的输入流
		StringReader in = new StringReader("海纳百川，有容乃大");
		char[] buffer = new char[1024];
		int len = -1;
		while((len = in.read(buffer)) != -1){
			System.out.print(new String(buffer,0,len));
		}
		
		//关闭流无效，因为本身就在存储在内存中
		in.close();
		out.close();
	}
}
