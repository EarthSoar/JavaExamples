package synchronize;

/**
 * @author 15626
 *	保证多线程并发访问时的同步操作，避免了线程安全性问题
 *	1.同步代码块：将需要同步的代码块用synchronized修饰
 */
class Apple1 implements Runnable{
	private int num = 100;
	public void run(){
		for(int i = 0;i < 100;i++){
			synchronized (this) {
				if(num > 0){	
					System.out.println(Thread.currentThread().getName()+"吃了第"+num+"个苹果");
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
public class SynchronizedDemo {
	public static void main(String[] args) {
		Apple1 a = new Apple1();
		new Thread(a,"A").start();
		new Thread(a,"B").start();
		new Thread(a,"C").start();
	}
}