package serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author 15626
 *	对象流的序列化和反序列化操作
 *	ObjectInputStream 用WriterObjcet 来做序列化
 *	ObjectOutputStream 用ReaderObject 来做反序列化
 *	需要做序列化的类必须实现Serializable接口 
 */
public class ObjectStreamDemo {
	public static void main(String[] args) throws Exception {
		File f = new File("file/111.txt");
		writeObject(f);//序列化
		readObject(f);//反序列化
	}
	public static void readObject(File f) throws Exception{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
		Student s = (Student)in.readObject();
		System.out.println(s);
		in.close();
		
	} 
	public static void writeObject(File f) throws Exception {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
		out.writeObject(new Student("小伙子",19,"12345"));
		out.close();
	}
}
class Student implements Serializable {
	/**
	 * 做反序列化操作必须存在序列化的字节码文件，由于随着版本升级肯定字节码会发生改变，java提供了序列化版本ID，
	 * 可以固定这一份字节码文件，解决了这个问题
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	//密码一般不会做序列化的，静态的字段和瞬态的字段不能做序列化，所以给密码加上瞬态transient修饰符
	//反序列化的结果就为null
	transient private String password;
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", password=" + password + "]";
	}
	public Student(String name, int age, String password) {
		super();
		this.name = name;
		this.age = age;
		this.password = password;
	}
}