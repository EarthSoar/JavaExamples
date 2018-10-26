package FileStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author 15626
 * 拷贝文件夹中的所有文件，包括子目录和子目录中的文件
 * 	首先判断是目录还是文件，如果是文件就直接用文件字节输入流和文件字节输出流完成复制。
 * 	如果是目录，首先对目录进行复制，也就是在目标文件夹中创建和源文件夹名称一样的文件夹，进入文件夹寻找文件接着复制
 * 	递归操作这些目录，直到复制完所有的文件和文件夹为止
 */
public class CopyAllFile {
	public static void main(String[] args) throws Exception {
		//1.创建源和目标
		File srcDir = new File("D:/资料/test"); 
		File destDir = new File("D:/资料/test_copy");
		if(!destDir.exists()){
			destDir.mkdirs();
		}
		copy(srcDir,destDir);
	}
	public static void copy(File src,File dest) throws Exception{
			if(src.isDirectory()){
				//是目录，就在目标文件夹中创建与源文件夹相同名称的文件夹
				File destDir = new File(dest,src.getName());
				destDir.mkdir();
				//列举出所有的文件对象
				File[] fs = src.listFiles();
				//遍历所有的文件对象
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
