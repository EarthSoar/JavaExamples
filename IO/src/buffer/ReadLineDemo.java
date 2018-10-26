package buffer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author 15626
 *	读取java文件中有多少行代码
 */
public class ReadLineDemo {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader(new File("file/testtest.txt")));
		int i = 0;
		while((in.readLine()) != null){
			i++;
		}
		System.out.println(i);
		in.close();
		
	}
}
