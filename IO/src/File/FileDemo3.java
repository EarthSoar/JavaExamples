package File;

import java.io.File;

public class FileDemo3 {
	public static void main(String[] args) {
		File dir = new File("C:/Users/15626/Desktop/�½��ļ��� (2)");
		//��Ҫɾ�����ַ���
		String deleteText = "�½��ı��ĵ�";
		//��ȡ�ļ����е������ļ�
		File[] fs = dir.listFiles();
		for (File file : fs) {
			if(file.getName().contains(deleteText)){
				String newFileName = file.getName().replace(deleteText, "");
				file.renameTo(new File(dir,newFileName));
			}
		}
	}
}
