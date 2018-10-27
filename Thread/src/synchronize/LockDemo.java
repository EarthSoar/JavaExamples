package synchronize;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *	3.ͬ������Lock�����ṩ�˱�synchronized������synchronized�������ӹ㷺������������ͬ��������ͬ������
 *			���еĹ���Lock���У�Ҳ�����������������˼��
 */
class Apple3 implements Runnable{
	private int num = 200;
	//����һ��������
	private final Lock lock = new ReentrantLock();
	public void run(){
		for(int i = 0;i < 200;i++){
			test();
		}
	}
	 public void test(){
		lock.lock();//��ȡ��
		try{
			if(num > 0){	
				System.out.println(Thread.currentThread().getName()+"���˵�"+num+"��ƻ��");
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
