package memory;
import java.io.*;
/**
 * @author 15626
 *	�ַ������ڴ������ѳ����е����ݴ洢��һ�������ַ�����
 *	�ַ���������� ��StringWriter
 *	�ַ�������������StringReader
 */
public class StringWriterReaderDemo {
	public static void main(String[] args) throws Exception {
		//�ַ����������
		StringWriter out = new StringWriter();
		out.write("��������Ϊһֻ˧˧������һֻС����");
		//��ȡ���������ַ���
		//System.out.print(out.toString());
		
		//�ַ�����������
		StringReader in = new StringReader("���ɰٴ��������˴�");
		char[] buffer = new char[1024];
		int len = -1;
		while((len = in.read(buffer)) != -1){
			System.out.print(new String(buffer,0,len));
		}
		
		//�ر�����Ч����Ϊ������ڴ洢���ڴ���
		in.close();
		out.close();
	}
}
