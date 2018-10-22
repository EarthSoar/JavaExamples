package File;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author 15626
 *	����ɸѡ·��ΪC:/Users/15626/Desktop/�½��ļ����к�׺��Ϊ.xmind���ļ�
 */
public class FilterDemo {
	public static void main(String[] args) {
		File dir = new File("C:/Users/15626/Desktop/�½��ļ���");
		File[] f = dir.listFiles(new FilenameFilter(){
			public boolean accept(File dir, String name) {//����FilenameFilter�ӿ��е�accept����
				return new File(dir,name).isFile() && name.endsWith(".xmind");
			}});
	for(File file : f){
		System.out.println(file);
	}
	}
}
