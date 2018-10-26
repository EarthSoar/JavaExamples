package buffer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *	获取以前写的java文件的行数，包括代码和注释等
 */
public class ReadLine {
	private static int line = 0;
	public static void main(String[] args) throws Exception{
		File f = new File("D:/javaWork");
		judge(f);
		System.out.println(line);
	}
	public static void judge(File f) throws Exception{
		if(!f.exists()){
			return;
		}
		if(f.isDirectory()){
			File[] fs = f.listFiles();
			for (File file : fs) {
				judge(file);
			}
		}else{
			if(f.getName().endsWith(".java")){
				count(f);
			}
		}

	}
	public static void count(File f) throws Exception{
		BufferedReader in = new BufferedReader(new FileReader(f));
		while((in.readLine()) != null){
			line++;
		}
		in.close();		
	}
}
