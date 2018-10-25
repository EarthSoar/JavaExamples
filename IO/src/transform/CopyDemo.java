package transform;

import java.io.*;


/**
 * @author 15626
 *	ת���������ֽ���ת��Ϊ�ַ���
 *	�ֽ������Բ���һ���ļ��������������ļ��ʹ��ı��ļ�
 *	�ַ���һ�������������ı��ļ������Բ������ģ��Ƕ��ֽ����ļ�ǿ
 *	�϶��������ֽ����������ַ���
 *
 *	���ֽ�������ת��Ϊ�ַ������� ��InputStreamReader
 *	���ֽ������ת��Ϊ�ַ��������OutputStreamWriter
 */

//���ֽ���ת��Ϊ�ַ�������ļ��Ŀ���
public class CopyDemo {
	public static void main(String[] args) throws Exception {
		//��ʼ�����ֽ���
		File srcFile = new File("file/test.txt");
		File destFile = new File("file/test_copy.txt");
		InputStream in = new FileInputStream(srcFile);
		OutputStream out = new FileOutputStream(destFile);
		
		Reader red = new InputStreamReader(in,"GBK");
		Writer wri = new OutputStreamWriter(out,"GBK");
		
		//ת��Ϊ�ַ���
		char[] buffer = new char[1024];
		int len = -1;
		while((len = red.read(buffer)) != -1){
			wri.write(buffer, 0, len);
		}
		red.close();
		wri.close();
	}
}
