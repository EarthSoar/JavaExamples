package junit4;

public class Employee {
	@MyBefore
	public void init(){
		System.out.println("-------��ʼ��-------");
	}
	@MyAfter
	public void end(){
		System.out.println("-------����---------");
	}
	@MyTest
	public void save() {
		System.out.println("�������");
	}
	@MyTest
	public void delete() {
		System.out.println("ɾ������");
	}
	@MyBefore
	public void ddd(){
		System.out.println("��ô˵��?");
	}
}
