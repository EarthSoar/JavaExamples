package scanner;
import java.io.*;
import java.util.Scanner;

/**
 * @author 15626
 *	Scanner:ɨ����
 */
@SuppressWarnings("unused")
public class ScannerDemo {
	public static void main(String[]args) throws Exception{
		//ɨ���ļ��������е�����
		//Scanner sc = new Scanner(new FileInputStream(new File("file/11.txt")));
		
		//ɨ���׼���������
		//Scanner sc = new Scanner(System.in);
		
		//ɨ���ַ����е�����
		Scanner sc = new Scanner("���!");
		while(sc.hasNextLine()){
			String  s = sc.nextLine();
			System.out.println(s);
		}
		sc.close();
	}
}
