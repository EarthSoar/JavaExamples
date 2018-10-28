package control;

/**
 *	线程的优先级
 *	 int getPriority() :返回线程的优先级。 
 * 	void setPriority(int newPriority) : 更改线程的优先级。 
 */
public class priority {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		//优先级的默认值为5
		System.out.println(Thread.currentThread().getPriority());//5
		//更改优先级(优先级可以在线程创建之后更改)
		Thread.currentThread().setPriority(7);
		System.out.println(Thread.currentThread().getPriority());//7
		
		//创建A线程，查看A线程的优先级，
		A a = new A();
		a.start();
		System.out.println(a.getPriority());//7
		
		//Thread类中也有三个常量
		System.out.println(a.MAX_PRIORITY);//10
		System.out.println(a.MIN_PRIORITY);//5
		System.out.println(a.NORM_PRIORITY);//1
	}
}

class A extends Thread{
	@Override
	public void run() {

	}
	
}