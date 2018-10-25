package memory;

import java.io.*;
/**
 * @author 15626
 *	�ֽ��ڴ���,����˵���ֽ�������
 *	�ֽ��ڴ������� �� ByteArrayOutputStream
 *	�ֽ��ڴ������ : ByteArrayInputStream
 */
public class ByteArrayStreamDemo {
	public static void main(String[] args) throws Exception {
		//�ֽ��ڴ���������ѳ��������д���ڴ��е�byte������
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		out.write("ABSAK".getBytes());
		//�ѳ����е����ݴ����˻��������У�toByteArray()����������ȡ������������
		byte[] buffer = out.toByteArray();
		
		//�ֽ��ڴ�������: ���ڴ��е����ݶ���������
		ByteArrayInputStream in = new ByteArrayInputStream(buffer);
		byte[] by = new byte[1024];
		int len = -1;
		while((len = in.read(by)) != -1){
			System.out.print(new String(by,0,len));
		}
		
		//�ر�����Ч����Ϊ������ڴ洢���ڴ���
		in.close();
		out.close();
	}
}
