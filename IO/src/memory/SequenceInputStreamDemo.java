package memory;

import java.io.FileInputStream;
import java.io.SequenceInputStream;

/**
 * @author 15626
 *	合并流或者叫顺序流
 *	把两个字节输入流合并成一个，也是有顺序的，先读取第一个，后第二个
 *	合并流也只有字节输入流，没有字符流，也没有输出流
 */
public class SequenceInputStreamDemo {
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		SequenceInputStream in = new SequenceInputStream(new FileInputStream("file/test.txt"),new FileInputStream("file/11.txt"));
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = in.read(buffer)) != -1){
			System.out.print(new String(buffer,0,len));
		}
		in.close();
	}
}
