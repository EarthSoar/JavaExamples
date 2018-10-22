package FileStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author 15626
 *	正确的关闭资源和处理IO异常
 */
public class CloseResouceDemo {
	public static void main(String[] args) {
		//test1();
		test2();
	}
	
	//java7提供的自动资源关闭
	public static void test2() {
		File srcFile = new File("C:/Users/15626/Desktop/test/123.txt");
		File targetFile = new File("C:/Users/15626/Desktop/test/123_copy.txt");
		try(//打开资源的代码
			FileInputStream in = new FileInputStream(srcFile);
			FileOutputStream out = new FileOutputStream(targetFile);
			){
			//3.输入 输出操作
			byte[] buffer = new byte[10];	
			int len = 0;
			while((len = in.read(buffer)) != -1){
				//String str = new String(buffer,0,len);
				out.write(buffer, 0, len);;
			}		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public static void test1() {
		FileInputStream in = null;
		FileOutputStream out = null;
		try{//可能出现问题的代码
			//1.创建源和目标
			File srcFile = new File("C:/Users/15626/Desktop/test/123.txt");
			File targetFile = new File("C:/Users/15626/Desktop/test/123_copy.txt");
			//2.创建输入流和输出流
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(targetFile);
			//3.输入 输出操作
			byte[] buffer = new byte[10];	
			int len = 0;
			while((len = in.read(buffer)) != -1){
				//String str = new String(buffer,0,len);
				out.write(buffer, 0, len);;
			}		
		}catch(Exception e){//处理异常
			e.printStackTrace();
		}finally{
			//4.关闭资源文件
			try{
				if(in != null){
					in.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				if(out != null){
					out.close();				
				}

			}catch(Exception e){
				e.printStackTrace();
			}			
		}
		
	}
	
}
