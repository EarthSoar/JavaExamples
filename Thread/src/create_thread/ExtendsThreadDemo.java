package create_thread;

/**
 *	多线程的创建：继承Thread类
 *	例子：有三个人分别是A,B,C要同时吃50个苹果
 *	多线程共享同一资源
 *	ABC分别吃了50个苹果，不合理
 */
class Person extends Thread{
	private int num = 50;
	Person(String name){
		super(name);
	}
	public void run(){
		while(num > 0){
			System.out.println(super.getName() + "吃了第"+num+"个苹果");
			num--;
		}
	}
}
public class ExtendsThreadDemo {
	public static void main(String[] args) {
		Person p1 = new Person("A");
		Person p2 = new Person("B");
		Person p3 = new Person("C");
		p1.start();
		p2.start();
		p3.start();
	}
}
