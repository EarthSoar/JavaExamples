package serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author 15626
 *	�����������л��ͷ����л�����
 *	ObjectInputStream ��WriterObjcet �������л�
 *	ObjectOutputStream ��ReaderObject ���������л�
 *	��Ҫ�����л��������ʵ��Serializable�ӿ� 
 */
public class ObjectStreamDemo {
	public static void main(String[] args) throws Exception {
		File f = new File("file/111.txt");
		writeObject(f);//���л�
		readObject(f);//�����л�
	}
	public static void readObject(File f) throws Exception{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
		Student s = (Student)in.readObject();
		System.out.println(s);
		in.close();
		
	} 
	public static void writeObject(File f) throws Exception {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
		out.writeObject(new Student("С����",19,"12345"));
		out.close();
	}
}
class Student implements Serializable {
	/**
	 * �������л���������������л����ֽ����ļ����������Ű汾�����϶��ֽ���ᷢ���ı䣬java�ṩ�����л��汾ID��
	 * ���Թ̶���һ���ֽ����ļ���������������
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	//����һ�㲻�������л��ģ���̬���ֶκ�˲̬���ֶβ��������л������Ը��������˲̬transient���η�
	//�����л��Ľ����Ϊnull
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