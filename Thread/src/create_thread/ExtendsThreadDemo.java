package create_thread;

/**
 *	���̵߳Ĵ������̳�Thread��
 *	���ӣ��������˷ֱ���A,B,CҪͬʱ��50��ƻ��
 *	���̹߳���ͬһ��Դ
 *	ABC�ֱ����50��ƻ����������
 */
class Person extends Thread{
	private int num = 50;
	Person(String name){
		super(name);
	}
	public void run(){
		while(num > 0){
			System.out.println(super.getName() + "���˵�"+num+"��ƻ��");
			num--;
		}
	}
}
public class ExtendsThreadDemo {
	public static void main(String[] args) {
		Person p1 = new Person("A");
		Person p2 = new Person("B");
		Person p3 = new Person("C");
		p1.start();
		p2.start();
		p3.start();
	}
}
