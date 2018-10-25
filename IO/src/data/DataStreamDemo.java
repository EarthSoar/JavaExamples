package data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 数据流：可以读写任意数据类型的数据
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
		out.writeUTF("你好");
		out.writeByte('a');
		out.close();
	}
	
}
