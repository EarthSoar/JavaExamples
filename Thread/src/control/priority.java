package control;

/**
 *	�̵߳����ȼ�
 *	 int getPriority() :�����̵߳����ȼ��� 
 * 	void setPriority(int newPriority) : �����̵߳����ȼ��� 
 */
public class priority {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		//���ȼ���Ĭ��ֵΪ5
		System.out.println(Thread.currentThread().getPriority());//5
		//�������ȼ�(���ȼ��������̴߳���֮�����)
		Thread.currentThread().setPriority(7);
		System.out.println(Thread.currentThread().getPriority());//7
		
		//����A�̣߳��鿴A�̵߳����ȼ���
		A a = new A();
		a.start();
		System.out.println(a.getPriority());//7
		
		//Thread����Ҳ����������
		System.out.println(a.MAX_PRIORITY);//10
		System.out.println(a.MIN_PRIORITY);//5
		System.out.println(a.NORM_PRIORITY);//1
	}
}

class A extends Thread{
	@Override
	public void run() {

	}
	
}