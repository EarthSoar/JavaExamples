package FileStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;

//�����ļ�����ָ��Ŀ¼��.java�ļ�������ָ����Ŀ¼
public class FileCopyDemo2 {
	public static void main(String []args) throws Exception{
		//�õ�ָ��Ŀ¼���ļ�
		File srcDir = new File("C:/Users/15626/Desktop/�½��ļ��� (2)");
		File destDir = new File("C:/Users/15626/Desktop/�½��ļ��� (2)/qqq");
		//ɸѡ����׺��.java���ļ��洢��fs����ļ�������
		File[] fs = srcDir.listFiles(new FilenameFilter(){
			@Override
			public boolean accept(File dir, String name){
				return new File(dir,name).isFile() && name.endsWith(".java");
			}
		});
		//������Щ�ļ�
		for (File srcFile : fs) {
			//1.����Ŀ��
			File destFile = new File(destDir,srcFile.getName());
			//2.���������������������
			FileInputStream in = new FileInputStream(srcFile);
			FileOutputStream out = new FileOutputStream(destFile);
			//3.�����������
			byte[] buffer = new byte[10];
			int len = -1;
			while((len = in.read(buffer)) != -1){
				out.write(buffer, 0, len);
			}
			//4.�ر���
			in.close();
			out.close();
//			//5.���ļ����и�������
//			File newFileName = new File(destDir,"222");
//			destFile.renameTo(newFileName);
//			File newFileName1 = new File(destDir,"2221");
//			destFile.renameTo(newFileName1);
		}
	}
}
