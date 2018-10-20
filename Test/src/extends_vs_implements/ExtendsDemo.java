package extends_vs_implements;
/**
 * 	案例:存在50个苹果,现在有请三个童鞋(小A,小B,小C)上台表演吃苹果.
 * 		因为A,B,C三个人可以同时吃苹果,此时得使用多线程技术来实现这个案例.
 *
 *       此处程序不合理,ABC每个线程都执行50次,即ABC每个人都吃一次编号50的苹果
 */
class Person extends Thread{
	private  int num= 50;
	Person(String name){
		super(name);
	}
	public void run() {
		for(int i = 0;i < 50;i++){
		if(num > 0)	
		System.out.println(super.getName()+"吃了第"+num--+"个苹果");
		}
	}	
}
//使用继承Thread的方式创建线程
public class ExtendsDemo {
	public static void main(String[] args){
		Person p1 = new Person("A");
		p1.start();
		Person p2 = new Person("B");
		p2.start();
		Person p3 = new Person("C");
		p3.start();
	}
}
