package File;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 15626                
 *	�г��ļ��ķֲ�ṹ,����Ч��:  OneDrive>File>java�ʼ�
 *
 */
public class FileStruct {
	public static void main(String[] args) {
		File f = new File("D:/OneDrive/File/java�ʼ�/BasicClass/Codes/1.txt");
		//����һ��List���ϴ����ЩĿ¼
		List<String> parentNames = new ArrayList<>();
		listAllParent(parentNames,f);
		Collections.reverse(parentNames); //�ߵ������е�Ԫ��
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
