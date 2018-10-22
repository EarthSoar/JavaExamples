package File;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author 15626
 *	File���еķ���
 */
public class FileDemo2 {
	public static void main(String[] args) throws IOException {
		//test1();
		//test2();
		//test3();
		//test4();
	}
	

	public static void test4() {
//		File���з���-Ŀ¼����
//		boolean isDirectory() :�ж��Ƿ���Ŀ¼
//		boolean mkdir()  :������ǰĿ¼
//		boolean mkdirs() :������ǰĿ¼���ϼ�Ŀ¼
//		String[] list() :�г����е��ļ���
//		File[] listFiles() :�г������ļ�����
//		static File[] listRoots() :�г�ϵͳ�̷�
		File f = new File ("D:/����/1/");
		System.out.println(f.isDirectory());
		File f1 = new File ("D:/����/1/11/111/1111");
		f1.mkdirs();
		
		String[] fs =f.list();
		for(String s : fs){
			System.out.println(s);
		}
		System.out.println("-----------");
		File[] fs2 = f.listFiles();
		for(File s2 : fs2){
			System.out.println(s2);
		}
		System.out.println("-----------");
		File[] ff = File.listRoots();
		for (File file : ff) {
			System.out.println(file);
		}
	}

	public static void test3() throws IOException {
//	File���з���-�ļ�����:
//			boolean isFile() :�Ƿ����ļ�
//			boolean createNewFile() :�����µ��ļ�
//			static File createTempFile(String prefix, String suffix) :������ʱ�ļ�
//			boolean delete() :ɾ���ļ�
//			void deleteOnExit() :��JVMֹͣʱɾ���ļ�
//			boolean exists():�ж��ļ��Ƿ����
//			boolean renameTo(File dest) :�����޸�����
		
		File f = new File ("D:/����/1/1.c");
//		System.out.println(f.isFile());
//		f.createNewFile();
//		if(!f.exists()){
//			f.createNewFile();
//		}else{
//			f.delete();
//		}
		File f1 = new File("D:/����/1/1111.w");
		
		System.out.println(f.renameTo(f1));
	}

	public static void test2() {
	/*
		���File״̬�ķ���:
		boolean canExecute() :�ж��Ƿ��ǿ�ִ���ļ�
		boolean canRead() :�жϸ��ļ��Ƿ�ɶ�
		boolean canWrite():�жϸ��ļ��Ƿ��д
		boolean isHidden():�жϸ��ļ��Ƿ��������ļ�
		long lastModified():�жϸ��ļ�������޸�ʱ��
		long length():��ȡ���ļ��ĳ��ȴ�С(��λ�ֽ�)
	 */
		File f = new File ("D:/����/1/11.c");
		System.out.println(f.canExecute());
		
		System.out.println(f.isHidden());
		
		System.out.println(new Date(f.lastModified()));
		
		
	}

	public static void test1(){
	/*����File·��������
		File getAbsoluteFile() :��ȡ����·��
		String getAbsolutePath():��ȡ����·��
		String getPath() :��ȡ�ļ�·��
		String getName() :��ȡ�ļ�����
		File getParentFile():��ȡ�ϼ�Ŀ¼�ļ�
		String getParent() :��ȡ�ϼ�Ŀ¼·��
	*/
		File f = new File("D:/����/1/11.c");
		File path= f.getAbsoluteFile();
		String path2 = f.getAbsolutePath();
		System.out.println(path);
		System.out.println(path2);
	
		String filepath1 = f.getPath();
		System.out.println(filepath1);
		
		String name =  f.getName();
		System.out.println(name);
		
		File parentpath = f.getParentFile();
		System.out.println(parentpath);
		String parentpath2 = f.getParent();
		System.out.println(parentpath2);
		
		
		
		
	}
}