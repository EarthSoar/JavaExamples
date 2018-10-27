package producer_consumer;

/**
 * 	共享资源类,或者说是一个缓冲区
 *
 *	用synchronized修饰方法，会自动获取锁，自动释放锁。java5之后，提供了Lock机制，可以自己获取，自己释放锁
 *	 把Lock机制写在了ShareResouce2.java
 */
public class ShareResource {
	private String name;
	private String sex;
	private boolean isEmpty = true;//判断共享区空和满的一个标志
	//生产者生产
	synchronized public void product(String name,String sex){
		try {
			while(!isEmpty){//共享区不空，生产者需要停下等待消费者消费
				/**
				 * this是同步锁(同步监听对象)，wait方法是Object类中 的方法，调用该方法就释放同步锁
				 * 然后JVM把该线程存放到等待池中，等待其他线程唤醒该线程
				 * 该方法只能被同步监听对象调用，否则报错IllegalMonitorStateException.
				 */
				
				this.wait();
			}
			//----------开始生产-----------
			this.name = name;
			Thread.sleep(10);
			this.sex = sex;
			//---------结束生产------------
			isEmpty = false;  //设置共享区为不空
			/**
			 * notify方法是唤醒等待池中的随机一个线程，把线程转移到锁池中等待(锁池中有机会获取到锁)
			 * notifyAll方法是唤醒等待池中的所有线程，把线程转移到锁池中等待
			 * 该方法只能被同步监听对象锁调用，否则报错
			 */
			this.notify();	//唤醒一个消费者               notify是唤醒其中一个，notifyAll是唤醒全部
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//消费者消费
	synchronized public void consume(){
		try {
			while(isEmpty){//当共享区为空时，消费者进行等待
				this.wait();
			}
			//------------开始消费-------------
			Thread.sleep(30);
			System.out.println(name + " " + sex);
			//------------结束消费-------------
			isEmpty = true;
			this.notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} 
}