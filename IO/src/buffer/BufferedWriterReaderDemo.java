package buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedWriterReaderDemo {
	public static void main(String[] args) throws Exception{
		BufferedWriter out = new BufferedWriter(new FileWriter("file/11.txt"));
		out.write("你好世界");
		out.newLine();
		out.write("迈开腿，向前跑");
		out.close();
		
		BufferedReader in = new BufferedReader(new FileReader("file/11.txt"));
		/*
		 * char[] ch = new char[1024];
		int len = -1;
		
		while((len = in.read(ch)) != -1){
			String str = new String(ch,0,len);
			System.out.print(str);
		}
		*/
		String line = null;
		while((line = in.readLine()) != null){
			System.out.println(line);
		}
		in.close();
	}
}
