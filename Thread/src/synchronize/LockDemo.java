package synchronize;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *	3.同步锁：Lock机制提供了比synchronized代码块和synchronized方法更加广泛的锁定操作，同步代码块和同步方法
 *			具有的功能Lock都有，也更加体现了面向对象思想
 */
class Apple3 implements Runnable{
	private int num = 200;
	//创建一个锁对象
	private final Lock lock = new ReentrantLock();
	public void run(){
		for(int i = 0;i < 200;i++){
			test();
		}
	}
	 public void test(){
		lock.lock();//获取锁
		try{
			if(num > 0){	
				System.out.println(Thread.currentThread().getName()+"吃了第"+num+"个苹果");
				Thread.sleep(10);
				num--;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
}
public class LockDemo {
	public static void main(String[] args) {
		Apple3 a = new Apple3();
		new Thread(a,"A").start();
		new Thread(a,"B").start();
		new Thread(a,"C").start();
	}
}
