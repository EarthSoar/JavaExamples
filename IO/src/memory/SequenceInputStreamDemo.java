package memory;

import java.io.FileInputStream;
import java.io.SequenceInputStream;

/**
 * @author 15626
 *	�ϲ������߽�˳����
 *	�������ֽ��������ϲ���һ����Ҳ����˳��ģ��ȶ�ȡ��һ������ڶ���
 *	�ϲ���Ҳֻ���ֽ���������û���ַ�����Ҳû�������
 */
public class SequenceInputStreamDemo {
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		SequenceInputStream in = new SequenceInputStream(new FileInputStream("file/test.txt"),new FileInputStream("file/11.txt"));
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = in.read(buffer)) != -1){
			System.out.print(new String(buffer,0,len));
		}
		in.close();
	}
}
