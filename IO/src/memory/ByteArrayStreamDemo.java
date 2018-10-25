package memory;

import java.io.*;
/**
 * @author 15626
 *	字节内存流,或者说是字节数组流
 *	字节内存输入流 ： ByteArrayOutputStream
 *	字节内存输出流 : ByteArrayInputStream
 */
public class ByteArrayStreamDemo {
	public static void main(String[] args) throws Exception {
		//字节内存输出流：把程序的内容写到内存中的byte数组中
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		out.write("ABSAK".getBytes());
		//把程序中的数据存在了缓冲数组中，toByteArray()方法用来获取缓冲区的数据
		byte[] buffer = out.toByteArray();
		
		//字节内存输入流: 把内存中的数据读到程序中
		ByteArrayInputStream in = new ByteArrayInputStream(buffer);
		byte[] by = new byte[1024];
		int len = -1;
		while((len = in.read(by)) != -1){
			System.out.print(new String(by,0,len));
		}
		
		//关闭流无效，因为本身就在存储在内存中
		in.close();
		out.close();
	}
}
