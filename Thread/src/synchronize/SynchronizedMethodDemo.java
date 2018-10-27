package synchronize;

/**
 * 2.ͬ����������synchronized���εķ�������ͬ��������Ҫע��run����������synchronized����
 *
 */
class Apple2 implements Runnable{
	private int num = 100;
	public void run(){
		for(int i = 0;i < 100;i++){
			test();
		}
	}
	synchronized public void test(){
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
public class SynchronizedMethodDemo {
	public static void main(String[] args) {
		Apple2 a = new Apple2();
		new Thread(a,"A").start();
		new Thread(a,"B").start();
		new Thread(a,"C").start();
	}
}
