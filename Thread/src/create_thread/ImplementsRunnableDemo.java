package create_thread;

/**
 *	第二种方式：实现Runnable接口
 */
class Apple implements Runnable{
	private int num = 50;
	public void run(){
		for(int i = 0; i < 50; i++){
			if(num > 0){	
				System.out.println(Thread.currentThread().getName()+"吃了第"+num--+"个苹果");
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
