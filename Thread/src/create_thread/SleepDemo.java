package create_thread;
/**
 *	sleep方法模拟网络延迟，可以发现出现了很多问题，打印num和num--是一对原子操作，必须同步进行
 *	这正是线程不安全造成的 
 *
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
public class SleepDemo {
	public static void main(String[] args) {
		Apple1 a = new Apple1();
		new Thread(a,"A").start();
		new Thread(a,"B").start();
		new Thread(a,"C").start();
	}
}