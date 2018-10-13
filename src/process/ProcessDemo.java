package process;

import java.io.IOException;
//如何用java语言开启一个进程
public class ProcessDemo {
	public static void main(String[] args) throws IOException{
		//方式一：使用Runtime的exec方法
		Runtime.getRuntime().exec("notepad");
		//方式二：使用ProcessBuilder类中的start方法
		ProcessBuilder pb = new ProcessBuilder("notepad");
		pb.start();
	}
}
