package print;

import java.io.File;
import java.io.PrintStream;

/**
 * @author 15626
 * �ֽڴ�ӡ��
 *  �����Զ�ˢ�µģ�����API˵�������������û��з�����println�ſ���ˢ�»�����
 */
public class PrintStreamDemo {
	public static void main(String[] args) throws Exception {
		File f = new File("file/123.txt");
		PrintStream p = new PrintStream(f);
		p.print("aa");
		p.println(121);
		p.append("a");
		p.close();
		
//		System.out.println();  //���д���ȼ�����������д���
//		PrintStream ps = System.out;
//		ps.println("a");
	}
}
