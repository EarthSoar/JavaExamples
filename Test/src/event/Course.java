package student;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private String courseName;
	private int maxLimit;
	private int num;
	public Course() {
	}
	public String getCourse() {
		return this.courseName;
	}
	public void addStudent() {
		num++;
		notifyEvent();
	}
	List<StudentLimitListener> listener = new ArrayList<>();
	public void addLimitListener(StudentLimitListener l) {
		listener.add(l);
	}
	public void notifyEvent() {
		StudentLimitEvent event = new StudentLimitEvent(this,maxLimit,num);
		for(int i = 0; i < listener.size(); i++) {
			listener.get(i).limit(event);
		}
	}
	public int getNum() {
		return num;
	}
	public int getMaxLimit() {
		return this.maxLimit;
	}
	public void setMaxLimit(int maxLimit) {
		this.maxLimit = maxLimit;
	}
	public void show() {
		System.out.println("事件源的信息：当前学生数为"+num + "," + "招生限额为 :" +maxLimit);
	}
}
