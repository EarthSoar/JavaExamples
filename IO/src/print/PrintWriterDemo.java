package print;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * @author 15626
 *	�ַ���ӡ��
 *	�������Զ�ˢ�º󣬼�new PrintWriter(new FileOutputStream(f),true);   true
 *	����println��������printf����\n�����ˢ�¡�
 *
 *	���������Զ�ˢ�£���Ҫ�ֶ�ˢ�£�����flush����������close���������ˢ��
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
