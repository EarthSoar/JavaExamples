package File;

import java.io.File;

public class FileDemo3 {
	public static void main(String[] args) {
		File dir = new File("C:/Users/15626/Desktop/新建文件夹 (2)");
		//需要删除的字符串
		String deleteText = "新建文本文档";
		//获取文件夹中的所有文件
		File[] fs = dir.listFiles();
		for (File file : fs) {
			if(file.getName().contains(deleteText)){
				String newFileName = file.getName().replace(deleteText, "");
				file.renameTo(new File(dir,newFileName));
			}
		}
	}
}
