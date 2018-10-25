package scanner;
import java.io.*;
import java.util.Scanner;

/**
 * @author 15626
 *	Scanner:扫描器
 */
@SuppressWarnings("unused")
public class ScannerDemo {
	public static void main(String[]args) throws Exception{
		//扫描文件输入流中的数据
		//Scanner sc = new Scanner(new FileInputStream(new File("file/11.txt")));
		
		//扫描标准输入的数据
		//Scanner sc = new Scanner(System.in);
		
		//扫描字符串中的数据
		Scanner sc = new Scanner("真好!");
		while(sc.hasNextLine()){
			String  s = sc.nextLine();
			System.out.println(s);
		}
		sc.close();
	}
}
