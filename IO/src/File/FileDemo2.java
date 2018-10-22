package File;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author 15626
 *	File类中的方法
 */
public class FileDemo2 {
	public static void main(String[] args) throws IOException {
		//test1();
		//test2();
		//test3();
		//test4();
	}
	

	public static void test4() {
//		File类中方法-目录操作
//		boolean isDirectory() :判断是否是目录
//		boolean mkdir()  :创建当前目录
//		boolean mkdirs() :创建当前目录和上级目录
//		String[] list() :列出所有的文件名
//		File[] listFiles() :列出所有文件对象
//		static File[] listRoots() :列出系统盘符
		File f = new File ("D:/资料/1/");
		System.out.println(f.isDirectory());
		File f1 = new File ("D:/资料/1/11/111/1111");
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
//	File类中方法-文件操作:
//			boolean isFile() :是否是文件
//			boolean createNewFile() :创建新的文件
//			static File createTempFile(String prefix, String suffix) :创建临时文件
//			boolean delete() :删除文件
//			void deleteOnExit() :在JVM停止时删除文件
//			boolean exists():判断文件是否存在
//			boolean renameTo(File dest) :重新修改名称
		
		File f = new File ("D:/资料/1/1.c");
//		System.out.println(f.isFile());
//		f.createNewFile();
//		if(!f.exists()){
//			f.createNewFile();
//		}else{
//			f.delete();
//		}
		File f1 = new File("D:/资料/1/1111.w");
		
		System.out.println(f.renameTo(f1));
	}

	public static void test2() {
	/*
		检测File状态的方法:
		boolean canExecute() :判断是否是可执行文件
		boolean canRead() :判断该文件是否可读
		boolean canWrite():判断该文件是否可写
		boolean isHidden():判断该文件是否是隐藏文件
		long lastModified():判断该文件的最后修改时间
		long length():获取该文件的长度大小(单位字节)
	 */
		File f = new File ("D:/资料/1/11.c");
		System.out.println(f.canExecute());
		
		System.out.println(f.isHidden());
		
		System.out.println(new Date(f.lastModified()));
		
		
	}

	public static void test1(){
	/*操作File路径和名称
		File getAbsoluteFile() :获取绝对路径
		String getAbsolutePath():获取绝对路径
		String getPath() :获取文件路径
		String getName() :获取文件名称
		File getParentFile():获取上级目录文件
		String getParent() :获取上级目录路径
	*/
		File f = new File("D:/资料/1/11.c");
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