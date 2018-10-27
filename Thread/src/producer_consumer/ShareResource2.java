package producer_consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *	��java5��ʼʹ��Lock����ȡ��synchronized������synchronized������
 *	ʹ��Condition�ӿڶ����await��signal��signalAll����ȡ��notify��notifyAll
 */
public class ShareResource2 {
	private String name;
	private String sex;
	private boolean isEmpty = true;
	private final Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void product(String name,String sex){
		lock.lock();//��ȡ��
		try {
			while(!isEmpty){//���գ�������Ҫ�ȴ�����������
				condition.await();//�ȴ����൱��this.wait();
			}
			this.name = name;
			Thread.sleep(10);
			this.sex = sex;
			
			isEmpty = false;//�ѹ�������Ϊ����
			condition.signal();//����һ���̣߳��൱��this.notify().  signalAll ���Ի���ȫ���߳�
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();//�ͷ���
		}
	}
	
	public void consume(){
		lock.lock();
		try {
			while(isEmpty){//������Ϊ�գ���Ҫ�ȴ�����������
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
