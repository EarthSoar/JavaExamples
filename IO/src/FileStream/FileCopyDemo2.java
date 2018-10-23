package FileStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;

//拷贝文件：把指定目录的.java文件拷贝到指定的目录
public class FileCopyDemo2 {
	public static void main(String []args) throws Exception{
		//得到指定目录的文件
		File srcDir = new File("C:/Users/15626/Desktop/新建文件夹 (2)");
		File destDir = new File("C:/Users/15626/Desktop/新建文件夹 (2)/qqq");
		//筛选出后缀是.java的文件存储在fs这个文件数组中
		File[] fs = srcDir.listFiles(new FilenameFilter(){
			@Override
			public boolean accept(File dir, String name){
				return new File(dir,name).isFile() && name.endsWith(".java");
			}
		});
		//遍历这些文件
		for (File srcFile : fs) {
			//1.创建目标
			File destFile = new File(destDir,srcFile.getName());
			//2.创建输入流和输出流对象
			FileInputStream in = new FileInputStream(srcFile);
			FileOutputStream out = new FileOutputStream(destFile);
			//3.输入输出操作
			byte[] buffer = new byte[10];
			int len = -1;
			while((len = in.read(buffer)) != -1){
				out.write(buffer, 0, len);
			}
			//4.关闭流
			in.close();
			out.close();
//			//5.对文件进行改名操作
//			File newFileName = new File(destDir,"222");
//			destFile.renameTo(newFileName);
//			File newFileName1 = new File(destDir,"2221");
//			destFile.renameTo(newFileName1);
		}
	}
}
