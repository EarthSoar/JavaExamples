package extends_vs_implements;
/**
 * 	����:����50��ƻ��,������������ͯЬ(СA,СB,СC)��̨���ݳ�ƻ��.
 * 		��ΪA,B,C�����˿���ͬʱ��ƻ��,��ʱ��ʹ�ö��̼߳�����ʵ���������.
 *
 *       �˴����򲻺���,ABCÿ���̶߳�ִ��50��,��ABCÿ���˶���һ�α��50��ƻ��
 */
class Person extends Thread{
	private  int num= 50;
	Person(String name){
		super(name);
	}
	public void run() {
		for(int i = 0;i < 50;i++){
		if(num > 0)	
		System.out.println(super.getName()+"���˵�"+num--+"��ƻ��");
		}
	}	
}
//ʹ�ü̳�Thread�ķ�ʽ�����߳�
public class ExtendsDemo {
	public static void main(String[] args){
		Person p1 = new Person("A");
		p1.start();
		Person p2 = new Person("B");
		p2.start();
		Person p3 = new Person("C");
		p3.start();
	}
}
