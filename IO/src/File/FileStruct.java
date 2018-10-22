package File;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 15626                
 *	列出文件的分层结构,期望效果:  OneDrive>File>java笔记
 *
 */
public class FileStruct {
	public static void main(String[] args) {
		File f = new File("D:/OneDrive/File/java笔记/BasicClass/Codes/1.txt");
		//定义一个List集合存放这些目录
		List<String> parentNames = new ArrayList<>();
		listAllParent(parentNames,f);
		Collections.reverse(parentNames); //颠倒集合中的元素
		StringBuilder sb = new StringBuilder(40);
		for(String name : parentNames){
			sb.append(name).append(">");
		}
		sb.deleteCharAt(sb.length() - 1);
		//System.out.println(parentNames);
		System.out.println(sb);
	}
	public static void listAllParent(List<String> parentNames,File f){
		if(!"".equals(f.getParentFile().getName())){
			parentNames.add(f.getParentFile().getName());
		}
		if(f.getParentFile().getParentFile()!= null){
			listAllParent(parentNames, f.getParentFile());
		}
	}
}
