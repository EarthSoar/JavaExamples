package FileStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

//获取进程数据-编译和运行Java代码.

public class ProcessDemo {
	public static void main(String[] args) throws Exception {
		String str = "System.out.println(\"你是最胖的!\");";
		eval(str);//调用这个函数，让函数执行上面的java代码，控制台打印出“你是最胖的”那句话
	}
	public static void eval(String str) throws Exception{
		//1.使用StringBuilder拼接一个完整的HelloWorld程序
		StringBuilder sb = new StringBuilder(80);
		sb.append("public class Hello {");
		sb.append("public static void main(String[] args){");
		sb.append(str);
		sb.append("}");
		sb.append("}");
		//System.out.println(sb);
		
		//2.把字符串保存到Hello.java文件中
		File f = new File("Hello.java");
		OutputStream out = new FileOutputStream(f);
		out.write(sb.toString().getBytes());
		out.close();
		
		//3.调用javac进程来编译Hello.java
		Process javacProcess = Runtime.getRuntime().exec("javac Hello.java");
		
		//4.返回javac的错误信息
		InputStream error = javacProcess.getErrorStream();
		//读取流中的数据
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = error.read(buffer)) != -1){
			String message = new String(buffer,0,len);
			System.out.print(message);
		}
		error.close();
	
		//5.调用java进程来运行Hello
		Process javaProcess = Runtime.getRuntime().exec("java Hello");
		//读取java进程中的流信息
		InputStream info = javaProcess.getInputStream();
		while((len = info.read(buffer)) != -1){
			String message = new String(buffer,0,len);
			System.out.print(message);
		}
		info.close();
		
		//6.删除java和class文件
		new File("Hello.java").delete();
		new File("Hello.class").delete();
	}
}
