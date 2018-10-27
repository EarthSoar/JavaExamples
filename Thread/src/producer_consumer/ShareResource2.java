package producer_consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *	从java5开始使用Lock机制取代synchronized代码块和synchronized方法，
 *	使用Condition接口对象的await，signal，signalAll方法取代notify，notifyAll
 */
public class ShareResource2 {
	private String name;
	private String sex;
	private boolean isEmpty = true;
	private final Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void product(String name,String sex){
		lock.lock();//获取锁
		try {
			while(!isEmpty){//不空，生产者要等待消费者消费
				condition.await();//等待，相当于this.wait();
			}
			this.name = name;
			Thread.sleep(10);
			this.sex = sex;
			
			isEmpty = false;//把共享区置为不空
			condition.signal();//唤醒一个线程，相当于this.notify().  signalAll 可以唤醒全部线程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();//释放锁
		}
	}
	
	public void consume(){
		lock.lock();
		try {
			while(isEmpty){//共享区为空，需要等待生产者生产
				condition.await();
			}
			
			Thread.sleep(20);
			System.out.println(this.name + " " + this.sex);
			
			isEmpty = false;
			condition.signal();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
}
