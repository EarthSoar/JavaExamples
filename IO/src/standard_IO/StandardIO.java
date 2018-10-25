package standard_IO;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * @author 15626
 *	标准的输入 ：   System.in  //从键盘输入         InputStream in = System.in;
 *	标准的输出：	 System.out //在屏幕上显示   PrintStream out = system.out;
 *	
 */
@SuppressWarnings("unused")
public class StandardIO {
	public static void main(String[] args) throws Exception {
//		//标准输入
//		InputStream in = System.in;
//		int n = in.read();
//		System.out.println(n);
//		//标准输出
//		PrintStream out = System.out;
//		out.print("101");
		
		//标准输出的重定向: 从屏幕上显示重定向为文件输出
		//System.setOut(new PrintStream("file/test.txt"));
		//System.out.println("重定向输出");
		
		//标准输入的重定向：从键盘输入重定向为文件输入
		System.setIn(new FileInputStream("file/11.txt"));
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = System.in.read(buffer)) != -1){
			System.out.println(new String(buffer,0,len));
		}
	}		
}
