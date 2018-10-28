package Work;
/**
 *创建两个线程，第一个线程启动后要调用wait方法使线程阻塞，等待另一个线程来唤醒。
 * 第二个线程启动后休眠一段时间，苏醒后调用notify方法唤醒第一个线程。（线程的工作自己定义）
 *
 */
class Thread1 extends Thread{
	Thread1(String name){
		super(name);
	}
	public void run(){
		System.out.println(this.getName()+"启动");
		synchronized (this) {
			try {
				System.out.println(super.getName()+"阻塞等待，释放t1同步锁");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int i = 0;i < 20;i++){
				System.out.println(super.getName()+"打印"+i);
			}
		}
	}
}
class Thread2 extends Thread{
	Thread t1 = null;
	public Thread2(Thread1 t1,String name){
		super(name);
		this.t1 = t1;
	}
	Thread2(String name){
		super(name);
	}
	public void run(){
		System.out.println(super.getName()+"启动");
		try {
			System.out.println(super.getName()+"睡眠");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (t1) {
			System.out.println(super.getName()+"获取到t1的同步锁");
			for(int i = 0;i < 20;i++){
				System.out.println(super.getName()+"打印"+i);
			}
			System.out.println(t1.getName()+"被唤醒");
			t1.notify();
		}
	}
}
public class Test {
	public static void main(String[] args) {
		Thread1 t1 = new Thread1("A线程");
		Thread2 t2 = new Thread2(t1,"B线程");
		t1.start();
		t2.start();
	}
}
