package FileStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author 15626
 * �����ļ����е������ļ���������Ŀ¼����Ŀ¼�е��ļ�
 * 	�����ж���Ŀ¼�����ļ���������ļ���ֱ�����ļ��ֽ����������ļ��ֽ��������ɸ��ơ�
 * 	�����Ŀ¼�����ȶ�Ŀ¼���и��ƣ�Ҳ������Ŀ���ļ����д�����Դ�ļ�������һ�����ļ��У������ļ���Ѱ���ļ����Ÿ���
 * 	�ݹ������ЩĿ¼��ֱ�����������е��ļ����ļ���Ϊֹ
 */
public class CopyAllFile {
	public static void main(String[] args) throws Exception {
		//1.����Դ��Ŀ��
		File srcDir = new File("D:/����/test"); 
		File destDir = new File("D:/����/test_copy");
		if(!destDir.exists()){
			destDir.mkdirs();
		}
		copy(srcDir,destDir);
	}
	public static void copy(File src,File dest) throws Exception{
			if(src.isDirectory()){
				//��Ŀ¼������Ŀ���ļ����д�����Դ�ļ�����ͬ���Ƶ��ļ���
				File destDir = new File(dest,src.getName());
				destDir.mkdir();
				//�оٳ����е��ļ�����
				File[] fs = src.listFiles();
				//�������е��ļ�����
				for (File file : fs) {
					copy(file,destDir);
				}
			}else{
				File file1 =new File(dest,src.getName());
				copyFile(src,file1);
			}
	}
	public static void copyFile(File inputFile,File outputFile) throws Exception{
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(inputFile));
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outputFile));
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = in.read(buffer)) != -1){
			out.write(buffer, 0, len);
		}
		in.close();
		out.close();
	}
}
