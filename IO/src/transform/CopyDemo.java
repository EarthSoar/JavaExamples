package transform;

import java.io.*;


/**
 * @author 15626
 *	转化流：把字节流转化为字符流
 *	字节流可以操作一切文件，包括二进制文件和纯文本文件
 *	字符流一般用来操作纯文本文件，可以操作中文，是对字节流的加强
 *	肯定是先有字节流，后有字符流
 *
 *	把字节输入流转化为字符输入流 ：InputStreamReader
 *	把字节输出流转化为字符输出流：OutputStreamWriter
 */

//把字节流转化为字符流完成文件的拷贝
public class CopyDemo {
	public static void main(String[] args) throws Exception {
		//开始先是字节流
		File srcFile = new File("file/test.txt");
		File destFile = new File("file/test_copy.txt");
		InputStream in = new FileInputStream(srcFile);
		OutputStream out = new FileOutputStream(destFile);
		
		Reader red = new InputStreamReader(in,"GBK");
		Writer wri = new OutputStreamWriter(out,"GBK");
		
		//转化为字符流
		char[] buffer = new char[1024];
		int len = -1;
		while((len = red.read(buffer)) != -1){
			wri.write(buffer, 0, len);
		}
		red.close();
		wri.close();
	}
}
