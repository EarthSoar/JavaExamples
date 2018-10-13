package extends_vs_implements;
class Apple implements Runnable{
	private int num = 50;
	public void run(){
		for(int i = 0; i< 50 ;i++){
			if(num > 0){
				System.out.println(Thread.currentThread().getName()+"吃了第"+num--+"个苹果");
			}//Thread.currentThread()   返回对当前正在执行的线程对象的引用。
		}
	}
}
//使用实现Runnable接口的方式，这种方法可以解决此问题
public class ImplementsDemo {
	public static void main(String[] args){
		Runnable r = new Apple();
		new Thread(r,"A").start();
		new Thread(r,"B").start();
		new Thread(r,"C").start();
	}
}
