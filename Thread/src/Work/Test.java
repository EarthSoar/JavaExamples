package Work;
/**
 *���������̣߳���һ���߳�������Ҫ����wait����ʹ�߳��������ȴ���һ���߳������ѡ�
 * �ڶ����߳�����������һ��ʱ�䣬���Ѻ����notify�������ѵ�һ���̡߳����̵߳Ĺ����Լ����壩
 *
 */
class Thread1 extends Thread{
	Thread1(String name){
		super(name);
	}
	public void run(){
		System.out.println(this.getName()+"����");
		synchronized (this) {
			try {
				System.out.println(super.getName()+"�����ȴ����ͷ�t1ͬ����");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int i = 0;i < 20;i++){
				System.out.println(super.getName()+"��ӡ"+i);
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
		System.out.println(super.getName()+"����");
		try {
			System.out.println(super.getName()+"˯��");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (t1) {
			System.out.println(super.getName()+"��ȡ��t1��ͬ����");
			for(int i = 0;i < 20;i++){
				System.out.println(super.getName()+"��ӡ"+i);
			}
			System.out.println(t1.getName()+"������");
			t1.notify();
		}
	}
}
public class Test {
	public static void main(String[] args) {
		Thread1 t1 = new Thread1("A�߳�");
		Thread2 t2 = new Thread2(t1,"B�߳�");
		t1.start();
		t2.start();
	}
}
