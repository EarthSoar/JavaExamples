package create_thread;

/**
 *	�ڶ��ַ�ʽ��ʵ��Runnable�ӿ�
 */
class Apple implements Runnable{
	private int num = 50;
	public void run(){
		for(int i = 0; i < 50; i++){
			if(num > 0){	
				System.out.println(Thread.currentThread().getName()+"���˵�"+num--+"��ƻ��");
			}
		}
	}
}
public class ImplementsRunnableDemo {
	public static void main(String[] args) {
		Apple a = new Apple();
		new Thread(a,"A").start();
		new Thread(a,"B").start();
		new Thread(a,"C").start();
	}
}
