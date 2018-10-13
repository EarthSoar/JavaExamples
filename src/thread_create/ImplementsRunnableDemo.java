package thread_create;
class MusicRunnable implements java.lang.Runnable{         //注意MusicRunnable类不是线程类或者线程子类
	public void run() {									   //接口的实现必须覆盖方法。				
		for(int i = 0 ;i < 50;i++)
		{
			System.out.println("听音乐"+i);
		}
	}
}
public class ImplementsRunnableDemo {
	public static void main(String[] args){
		for(int i = 0 ;i < 50;i++)
		{
			System.out.println("玩游戏"+i);
			if( i == 10){
				Runnable t = new MusicRunnable();        //启动线程必须用线程类对象调用start();
				new Thread(t).start();             //类Thread的一个构造器中Thread(Runnable target)分配新的 Thread 对象。
			}
		}
	}
}
