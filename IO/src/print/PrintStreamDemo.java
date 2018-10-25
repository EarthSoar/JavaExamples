package print;

import java.io.File;
import java.io.PrintStream;

/**
 * @author 15626
 * 字节打印流
 *  可以自动刷新的，不想API说的那样，必须用换行符或者println才可以刷新缓冲区
 */
public class PrintStreamDemo {
	public static void main(String[] args) throws Exception {
		File f = new File("file/123.txt");
		PrintStream p = new PrintStream(f);
		p.print("aa");
		p.println(121);
		p.append("a");
		p.close();
		
//		System.out.println();  //这行代码等价于下面的两行代码
//		PrintStream ps = System.out;
//		ps.println("a");
	}
}
