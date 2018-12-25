package student;

import java.util.EventObject;

public class StudentLimitEvent extends EventObject {
	private static final long serialVersionUID = 1L;
	
	private int maxLimit;
	private int num;
	public StudentLimitEvent(Object source,int maxLimit,int num) {
		super(source);
		this.maxLimit = maxLimit;
		this.num = num;
	}
	public void show() {
		System.out.print("当前学生数为"+num);
		if(num <= maxLimit) {
			System.out.print("可以继续招生\t");
		}else {
			System.out.print("达到限额停止招生\t");
		}
	}
}
