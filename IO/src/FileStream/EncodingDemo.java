package FileStream;

import java.util.Arrays;

//�ַ��ı���ͽ���
public class EncodingDemo {
	public static void main(String[] args) throws Exception {
		String str = "�ڷ�";
		byte[] data = str.getBytes("GBK");
		System.out.println(Arrays.toString(data));
		
		String s = new String(data,"ISO-8859-1");
		System.out.println(s);//����������
		
		data = s.getBytes("ISO-8859-1");//�õ�ԭ��������
		System.out.println(Arrays.toString(data));
		String ss = new String(data,"GBK");
		System.out.println(ss);
	}
}
