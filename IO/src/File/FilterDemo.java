package File;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author 15626
 *	过滤筛选路径为C:/Users/15626/Desktop/新建文件夹中后缀名为.xmind的文件
 */
public class FilterDemo {
	public static void main(String[] args) {
		File dir = new File("C:/Users/15626/Desktop/新建文件夹");
		File[] f = dir.listFiles(new FilenameFilter(){
			public boolean accept(File dir, String name) {//覆盖FilenameFilter接口中的accept方法
				return new File(dir,name).isFile() && name.endsWith(".xmind");
			}});
	for(File file : f){
		System.out.println(file);
	}
	}
}
