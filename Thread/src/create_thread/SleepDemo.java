package create_thread;
/**
 *	sleep����ģ�������ӳ٣����Է��ֳ����˺ܶ����⣬��ӡnum��num--��һ��ԭ�Ӳ���������ͬ������
 *	�������̲߳���ȫ��ɵ� 
 *
 */
class Apple1 implements Runnable{
	private int num = 100;
	public void run(){
		for(int i = 0;i < 100;i++){
			synchronized (this) {
				if(num > 0){	
					System.out.println(Thread.currentThread().getName()+"���˵�"+num+"��ƻ��");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					num--;
				}
			}
		}
	}
}
public class SleepDemo {
	public static void main(String[] args) {
		Apple1 a = new Apple1();
		new Thread(a,"A").start();
		new Thread(a,"B").start();
		new Thread(a,"C").start();
	}
}