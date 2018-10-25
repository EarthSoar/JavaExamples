package memory;
import java.io.*;
/**
 * @author 15626
 *	�ַ��ڴ�������˵���ַ�������
 *	�ַ��ڴ��������CharArrayWriter
 *	�ַ��ڴ���������CharArrayReader
 */
public class CharArrayReaderWriterDemo {
	public static void main(String[] args) throws Exception {
		//�ַ��ڴ������ �� �ӳ�������ݴ洢���ڴ��е�һ������������
		CharArrayWriter cWriter = new CharArrayWriter();
		cWriter.write("��������������Ʋ�");
		//��ȡ���������е�����,��toCharArray()������ȡ
		char[] ch= cWriter.toCharArray();
		
		//�ַ��ڴ������������ڴ��б����ݶ�ȡ����������
		CharArrayReader sReader = new CharArrayReader(ch);
		char[] buffer = new char[1024];
		int len = -1;
		while((len = sReader.read(buffer)) != -1){
			System.out.println(new String(buffer,0,len));
		}
		
		
		//�ر�����Ч����Ϊ������ڴ洢���ڴ���
		sReader.close();
		cWriter.close();
	}
}
