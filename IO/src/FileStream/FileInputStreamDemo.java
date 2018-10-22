package FileStream;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

@SuppressWarnings("unused")
public class FileInputStreamDemo {
	public static void main(String[]args) throws Exception{
		//1.����Դ
		File f = new File("C:/Users/15626/Desktop/test/111.txt");
		//2.�����ļ�����������
		FileInputStream in = new FileInputStream(f);
		//3.������
		/*
		 *  int read() 	�Ӵ��������ж�ȡһ�������ֽڡ� 
		 int read(byte[] b) �Ӵ��������н���� b.length ���ֽڵ����ݶ���һ�� byte ������
		 int read(byte[] b, int off, int len)�Ӵ��������н���� len ���ֽڵ����ݶ���һ�� byte ������
		 */
		
		//��ȡ�ļ������е�����
		byte[] buffer = new byte[5];//����һ���������鳤��Ϊ5��ÿ��ֻ�ܶ�ȡ5���ֽ�
		int len = 0;//��ǰ��ȡ���ֽ�����û���ֽھͷ��� -1
		while((len = in.read(buffer))!= -1 ){
			String str = new String(buffer,0,len);
			System.out.println(str);
		}

		//int data = in.read();//��ȡһ���ֽ�
		//System.out.println(data);		
		
		//byte[] buffer = new byte[5];//����һ����������
		//int ret = in.read(buffer);  //���ļ������ݶ�ȡ��byte���������У����ض�ȡ���ݵĳ���
		//System.out.println(ret);
		//System.out.println(Arrays.toString(buffer));

		//in.read(buffer, 0, 3);
		//��byte��������ת�����ַ���
		//String str = new String(buffer,0,3);
		//System.out.println(str);
		
		//4.�ر���Դ
		in.close();
	}
}
