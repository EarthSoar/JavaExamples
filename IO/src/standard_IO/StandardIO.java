package standard_IO;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * @author 15626
 *	��׼������ ��   System.in  //�Ӽ�������         InputStream in = System.in;
 *	��׼�������	 System.out //����Ļ����ʾ   PrintStream out = system.out;
 *	
 */
@SuppressWarnings("unused")
public class StandardIO {
	public static void main(String[] args) throws Exception {
//		//��׼����
//		InputStream in = System.in;
//		int n = in.read();
//		System.out.println(n);
//		//��׼���
//		PrintStream out = System.out;
//		out.print("101");
		
		//��׼������ض���: ����Ļ����ʾ�ض���Ϊ�ļ����
		//System.setOut(new PrintStream("file/test.txt"));
		//System.out.println("�ض������");
		
		//��׼������ض��򣺴Ӽ��������ض���Ϊ�ļ�����
		System.setIn(new FileInputStream("file/11.txt"));
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = System.in.read(buffer)) != -1){
			System.out.println(new String(buffer,0,len));
		}
	}		
}
