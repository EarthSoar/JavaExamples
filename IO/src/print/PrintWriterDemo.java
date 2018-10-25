package print;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * @author 15626
 *	字符打印流
 *	当启用自动刷新后，即new PrintWriter(new FileOutputStream(f),true);   true
 *	调用println方法或者printf或者\n后进行刷新。
 *
 *	当不启动自动刷新，需要手动刷新，调用flush方法，或者close方法会进行刷新
 */
public class PrintWriterDemo {
	public static void main(String[]args) throws Exception{
		File f = new File("file/123.txt");
		PrintWriter p = new PrintWriter(new FileOutputStream(f),true);
		p.print("wqe");
		p.println();
		p.close();
	}
}
