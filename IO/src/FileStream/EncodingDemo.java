package FileStream;

import java.util.Arrays;

//字符的编码和解码
public class EncodingDemo {
	public static void main(String[] args) throws Exception {
		String str = "腾飞";
		byte[] data = str.getBytes("GBK");
		System.out.println(Arrays.toString(data));
		
		String s = new String(data,"ISO-8859-1");
		System.out.println(s);//出现了乱码
		
		data = s.getBytes("ISO-8859-1");//得到原来的数据
		System.out.println(Arrays.toString(data));
		String ss = new String(data,"GBK");
		System.out.println(ss);
	}
}
