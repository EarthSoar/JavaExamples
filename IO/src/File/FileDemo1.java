package File;
import java.io.*;

/**
 * @author 15626
 *	��ͬ����ϵͳ��·���ָ������������Ʒָ�����һ����Ϊ�˽��������⣬java�ṩ�˼�����ȡ��ǰϵͳ�ĳ���
 *	
 */
public class FileDemo1 {
	public static void main(String[]args){
		String pathSeparator = File.pathSeparator;
		char pathSeparatoraChar = File.pathSeparatorChar;
		
		String separator = File.separator;
		char separatorChar = File.separatorChar;
		
		System.out.println(pathSeparator);//Windowsϵͳ��Ϊ �� ����
		System.out.println(pathSeparatoraChar);//Windowsϵͳ��Ϊ �� ����
		
		System.out.println(separator);//Windowsϵͳ��Ϊ �� \ ��;
		System.out.println(separatorChar);//Windowsϵͳ��Ϊ �� \ ��;
		
		System.out.println("================");
		
		//File���еĹ�����������File����
		File f = new File("D:/����/123.txt");
		System.out.println(f);
		File f1 = new File("D:/����","123.txt");
		System.out.println(f1);
		File dir = new File("D:/����");
		File f2 = new File(dir,"123.txt");
		System.out.println(f2);
	}
	
}
