package method;


import java.lang.reflect.Method;

/**
 *	�÷�����ƻ�ȡ���еķ���
 *	public Method[] getMethods():��ȡ��������ͼ̳й��������е�public����
	public Method[] getDeclaredMethods():��ȡ�����������еķ���(�������̳е�,�ͷ���Ȩ���޹�)
	
	public Method getMethod(String methodName, Class<?>... parameterTypes):
	��ʾ����ָ����һ�������ķ���(�����̳е�)
 */
@SuppressWarnings("unused")
class Person{
	public void doWork(){}
	public String doWork(String name){
		return name;
	}
	private void eat(){}
}
public class GetMethodDemo {
	public static void main(String[] args) throws Exception {
		//getAll();//��ȡ���з���
		getOne();//��ȡ���е�һ������
	}
	public static void getOne() throws Exception {
		//��ȡ����ֽ������
		Class<Person> clz = Person.class;
		Method[] me = clz.getMethods();//��ʾ����ָ����һ�������ķ���(�����̳е�)
		for (Method method : me) {
			System.out.println(method);
		}
		System.out.println("============");
		me = clz.getDeclaredMethods();//��ȡ�����������еķ���(�������̳е�,�ͷ���Ȩ���޹�)
		for (Method method : me) {
			System.out.println(method);
		}
	}
	public static void getAll() throws Exception {
		//��ȡ����ֽ������
		Class<Person> clz = Person.class;
		//��ȡdoWork()����
		Method m =clz.getMethod("doWork");
		System.out.println(m);
		System.out.println("============");
		m = clz.getMethod("doWork", String.class);
		System.out.println(m);
		System.out.println("============");
		m = clz.getDeclaredMethod("eat");//���÷�����ִ��
		System.out.println(m);
	}
}
