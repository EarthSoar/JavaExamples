package randomAccessFile;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * ��������ļ������ļ�������λ�ÿ��Խ��ж�д����
 *
 */
public class RandomAccessFileDemo {
	public static void main(String[] args) throws Exception {
		File f = new File("file/222.txt");
		write(f);
		reade(f);
	}

	private static void reade(File f) throws Exception {
		RandomAccessFile in = new RandomAccessFile(f,"r");
		System.out.println("�ļ�ָ�� = "+ in.getFilePointer());
		
		int i =  in.readInt();
		System.out.println(i);
		System.out.println("�ļ�ָ�� = "+ in.getFilePointer());
		
		String str = in.readUTF();  //�����UTF������������UTF,��UTF��2���ֽ�
		System.out.println(str);
		System.out.println("�ļ�ָ�� = "+ in.getFilePointer());

		//in.seek(0);�ı��ļ�ָ��
		int c = in.readInt();
		System.out.println(c);
		System.out.println("�ļ�ָ�� = "+ in.getFilePointer());
		in.close();
	}

	private static void write(File f) throws Exception {
		RandomAccessFile out = new RandomAccessFile(f,"rw");
		out.writeInt(11);
		out.writeUTF("���");
		out.writeInt(10);
		out.close();
	}
	
}
