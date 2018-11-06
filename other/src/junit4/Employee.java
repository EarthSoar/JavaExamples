package junit4;

public class Employee {
	@MyBefore
	public void init(){
		System.out.println("-------初始化-------");
	}
	@MyAfter
	public void end(){
		System.out.println("-------销毁---------");
	}
	@MyTest
	public void save() {
		System.out.println("保存操作");
	}
	@MyTest
	public void delete() {
		System.out.println("删除操作");
	}
	@MyBefore
	public void ddd(){
		System.out.println("怎么说呢?");
	}
}
