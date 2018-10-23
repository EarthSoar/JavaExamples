package buffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//字节输入输出包装流
public class BufferedStreamDemo {
	public static void main(String[] args) throws Exception {
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("file/test.txt"));
		byte[] bot = "Hello".getBytes();
		out.write(bot);
		out.close();
		
		BufferedInputStream in = new BufferedInputStream(new FileInputStream("file/test.txt"));
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = in.read(buffer)) != -1){
			String str = new String(buffer,0,len);
			System.out.println(str);
		}
		in.close();
		
	}
}
