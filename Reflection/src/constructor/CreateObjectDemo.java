package constructor;

import java.lang.reflect.Constructor;

/**
 *	ʹ�û�ȡ�Ĺ�������������
 */
class People{
	public People(){
		System.out.println("�޲������췽��");
	}
	public People(String name,int age){
		System.out.println(name + "," + age);
	}
	@SuppressWarnings("unused")
	private People(String name){
		System.out.println(name);
	}
}
public class CreateObjectDemo {
	public static void main(String[] args) throws Exception {
		//��ȡPeople����ֽ������
		Class<People> clz = People.class;
		Constructor<?> con = clz.getConstructor();
		con.newInstance();
		System.out.println("===============");
		
		con = clz.getConstructor(String.class,int.class);
		con.newInstance("XXX",17);
	
		con = clz.getDeclaredConstructor(String.class);
		con.setAccessible(true);//���õ�ǰ�������ɷ��ʣ�����Constructor�ĸ���AccessibleObject�з���
		con.newInstance("OOO");
	}
}
