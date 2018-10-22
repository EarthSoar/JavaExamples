package File;
import java.io.*;

/**
 * @author 15626
 *	不同操作系统的路径分隔符和名称名称分隔符不一样，为了解决这个问题，java提供了几个获取当前系统的常量
 *	
 */
public class FileDemo1 {
	public static void main(String[]args){
		String pathSeparator = File.pathSeparator;
		char pathSeparatoraChar = File.pathSeparatorChar;
		
		String separator = File.separator;
		char separatorChar = File.separatorChar;
		
		System.out.println(pathSeparator);//Windows系统下为 “ ；”
		System.out.println(pathSeparatoraChar);//Windows系统下为 “ ；”
		
		System.out.println(separator);//Windows系统下为 “ \ ”;
		System.out.println(separatorChar);//Windows系统下为 “ \ ”;
		
		System.out.println("================");
		
		//File类中的构造器，创建File对象
		File f = new File("D:/资料/123.txt");
		System.out.println(f);
		File f1 = new File("D:/资料","123.txt");
		System.out.println(f1);
		File dir = new File("D:/资料");
		File f2 = new File(dir,"123.txt");
		System.out.println(f2);
	}
	
}
