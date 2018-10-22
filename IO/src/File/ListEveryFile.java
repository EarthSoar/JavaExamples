package File;

import java.io.File;

/**
 * @author 15626
 *	����:�г�ָ��Ŀ¼�����е��ļ�,�������ļ����е������ļ�(ʹ�õݹ��㷨(recursion)).
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
