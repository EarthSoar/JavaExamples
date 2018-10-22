package FileStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author 15626
 *	��ȷ�Ĺر���Դ�ʹ���IO�쳣
 */
public class CloseResouceDemo {
	public static void main(String[] args) {
		//test1();
		test2();
	}
	
	//java7�ṩ���Զ���Դ�ر�
	public static void test2() {
		File srcFile = new File("C:/Users/15626/Desktop/test/123.txt");
		File targetFile = new File("C:/Users/15626/Desktop/test/123_copy.txt");
		try(//����Դ�Ĵ���
			FileInputStream in = new FileInputStream(srcFile);
			FileOutputStream out = new FileOutputStream(targetFile);
			){
			//3.���� �������
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
		try{//���ܳ�������Ĵ���
			//1.����Դ��Ŀ��
			File srcFile = new File("C:/Users/15626/Desktop/test/123.txt");
			File targetFile = new File("C:/Users/15626/Desktop/test/123_copy.txt");
			//2.�����������������
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(targetFile);
			//3.���� �������
			byte[] buffer = new byte[10];	
			int len = 0;
			while((len = in.read(buffer)) != -1){
				//String str = new String(buffer,0,len);
				out.write(buffer, 0, len);;
			}		
		}catch(Exception e){//�����쳣
			e.printStackTrace();
		}finally{
			//4.�ر���Դ�ļ�
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
