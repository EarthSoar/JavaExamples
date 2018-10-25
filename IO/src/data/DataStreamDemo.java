package data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * �����������Զ�д�����������͵�����
 *
 */
public class DataStreamDemo {
	public static void main(String[] args) throws Exception {
		File f = new File("file/111.txt");
		write(f);
		reade(f);
	}

	private static void reade(File f) throws Exception {
		DataInputStream in = new DataInputStream(new FileInputStream(f));
		System.out.println(in.readInt());
		System.out.println(in.readUTF());
		System.out.println((char)in.readByte());
		in.close();
	}

	private static void write(File f) throws Exception {
		DataOutputStream out = new DataOutputStream(new FileOutputStream(f));
		out.writeInt(11);
		out.writeUTF("���");
		out.writeByte('a');
		out.close();
	}
	
}
