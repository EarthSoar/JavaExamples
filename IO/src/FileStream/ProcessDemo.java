package FileStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

//��ȡ��������-���������Java����.

public class ProcessDemo {
	public static void main(String[] args) throws Exception {
		String str = "System.out.println(\"�������ֵ�!\");";
		eval(str);//��������������ú���ִ�������java���룬����̨��ӡ�����������ֵġ��Ǿ仰
	}
	public static void eval(String str) throws Exception{
		//1.ʹ��StringBuilderƴ��һ��������HelloWorld����
		StringBuilder sb = new StringBuilder(80);
		sb.append("public class Hello {");
		sb.append("public static void main(String[] args){");
		sb.append(str);
		sb.append("}");
		sb.append("}");
		//System.out.println(sb);
		
		//2.���ַ������浽Hello.java�ļ���
		File f = new File("Hello.java");
		OutputStream out = new FileOutputStream(f);
		out.write(sb.toString().getBytes());
		out.close();
		
		//3.����javac����������Hello.java
		Process javacProcess = Runtime.getRuntime().exec("javac Hello.java");
		
		//4.����javac�Ĵ�����Ϣ
		InputStream error = javacProcess.getErrorStream();
		//��ȡ���е�����
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = error.read(buffer)) != -1){
			String message = new String(buffer,0,len);
			System.out.print(message);
		}
		error.close();
	
		//5.����java����������Hello
		Process javaProcess = Runtime.getRuntime().exec("java Hello");
		//��ȡjava�����е�����Ϣ
		InputStream info = javaProcess.getInputStream();
		while((len = info.read(buffer)) != -1){
			String message = new String(buffer,0,len);
			System.out.print(message);
		}
		info.close();
		
		//6.ɾ��java��class�ļ�
		new File("Hello.java").delete();
		new File("Hello.class").delete();
	}
}
