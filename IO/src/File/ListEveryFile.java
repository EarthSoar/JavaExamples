package File;

import java.io.File;

/**
 * @author 15626
 *	需求:列出指定目录中所有的文件,包括子文件夹中的所有文件(使用递归算法(recursion)).
 */
public class ListEveryFile {
	public static void main(String [] args){
		File f = new File("D:/OneDrive/File/Homework");
		listAllFile(f);
	}
	public static void listAllFile(File f){
		File[] fs = f.listFiles();
		for (File file : fs) {
			System.out.println(file);
			if( file.isDirectory()){
				listAllFile(file);
			}
		}
	}
}
