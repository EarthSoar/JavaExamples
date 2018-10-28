package control;

public class DeamonDemo {
	public static void main(String[] args) {
		//判断main线程是否后台线程
//		boolean b = Thread.currentThread().isDaemon();
//		System.out.println(b);
		//设置main线程为后台线程,报错，线程一旦创建就不能修改为后台线程
		//Thread.currentThread().setDaemon(true);
		//创建并启动Demo线程,设置为后台线程
		/**
		 * 此时Demo为守护线程，当所有的前台线程都执行完毕后，守护线程自动死亡
		 * 在这会发现，当主线程执行完毕后，守护线程Demo没有执行完自己的方法都结束了
		 * 但让也不一定守护线程立马就停止了，也要有反应时间
		 */
		Demo d = new Demo();
		d.setDaemon(true);
		d.start();
		for (int i = 0; i < 20; i++) {
			System.out.println("main" + "--" + i);
		}
	}
}

class Demo extends Thread{
	@Override
	public void run() {
		for(int i = 0;i < 50;i++){
			System.out.println("Demo" + "--" + i);
		}
	}
}