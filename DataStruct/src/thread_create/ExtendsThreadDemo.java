package thread_create;
//继承方式 创建和启动线程
class MusicThread extends Thread{      //MusicThread是线程子类
	public void run() {               //子类必须重写run()方法
		for(int i = 0 ;i < 50;i++)
		{
			System.out.println("听音乐"+i);
		}
	}
	
}
public class ExtendsThreadDemo {
	public static void main(String[] args){
		for(int i = 0 ;i < 50;i++)
		{
			System.out.println("玩游戏"+i);
			if( i == 10){
				MusicThread t = new MusicThread();  //创建线程子类的实例
				t.start(); //底层也调用了run();  启动线程
			}
		}
			
	}
}
