package buffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author 15626
 *	操作字符或者字节流都应该用缓冲流包装起来，现在比较一下用缓冲流和不用缓冲流的情况写，复制一个文件所花费时间
 *	长度的比较
 */
public class BufferCompare {
	public static void main(String[] args) throws Exception {
		File srcFile = new File("C:/Users/15626/Desktop/File/尚学堂_百战程序员_1573题1.0版.pdf");
		File destFile = new File("C:/Users/15626/Desktop/File/copy.pdf");
		//test1(srcFile,destFile);//不用缓冲流包装       
		test2(srcFile,destFile);//用缓冲流包装       
	}
	//使用缓冲流,从内存每次读取1024个字节：15ms
	public static void test2(File srcFile, File destFile) throws Exception {
		long begin = System.currentTimeMillis();
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destFile));
	
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = in.read(buffer)) != -1){
			out.write(buffer, 0, len);
		}
		in.close();
		out.close();
		System.out.print(System.currentTimeMillis() - begin);
	}

	//使用字节流，从磁盘中每次读取1024个字节：38ms
	public static void test1(File srcFile,File destFile) throws Exception {
		long begin = System.currentTimeMillis();
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = in.read(buffer)) != -1){
			out.write(buffer, 0, len);
		}
		in.close();
		out.close();
		System.out.print(System.currentTimeMillis() - begin);
	}
}
