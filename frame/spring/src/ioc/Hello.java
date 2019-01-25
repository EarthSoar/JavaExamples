package ioc;

public class Hello {
	private String name;
	
	public Hello() {
		System.out.println("构造器");
	}
	
	public void open(){
		System.out.println("初始化方法");
	}
	
	public void close() {
		System.out.println("关闭方法");
	}
	public void setName(String name) {
		this.name = name;
	}
	public void sayHello() {
		System.out.println("Hello," + name);
	}
}
