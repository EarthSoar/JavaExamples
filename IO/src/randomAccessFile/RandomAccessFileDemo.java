package randomAccessFile;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * 随机访问文件：在文件的任意位置可以进行读写操作
 *
 */
public class RandomAccessFileDemo {
	public static void main(String[] args) throws Exception {
		File f = new File("file/222.txt");
		write(f);
		reade(f);
	}

	private static void reade(File f) throws Exception {
		RandomAccessFile in = new RandomAccessFile(f,"r");
		System.out.println("文件指针 = "+ in.getFilePointer());
		
		int i =  in.readInt();
		System.out.println(i);
		System.out.println("文件指针 = "+ in.getFilePointer());
		
		String str = in.readUTF();  //这里的UTF并不是真正的UTF,比UTF多2个字节
		System.out.println(str);
		System.out.println("文件指针 = "+ in.getFilePointer());

		//in.seek(0);改变文件指针
		int c = in.readInt();
		System.out.println(c);
		System.out.println("文件指针 = "+ in.getFilePointer());
		in.close();
	}

	private static void write(File f) throws Exception {
		RandomAccessFile out = new RandomAccessFile(f,"rw");
		out.writeInt(11);
		out.writeUTF("你好");
		out.writeInt(10);
		out.close();
	}
	
}
