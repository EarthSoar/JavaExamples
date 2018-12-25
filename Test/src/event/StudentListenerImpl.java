package student;

public class StudentListenerImpl implements StudentLimitListener{
	public void limit(StudentLimitEvent e) {
		System.out.print("课程对象中的信息:事件源" + e.getSource().getClass().getName());
		System.out.print("发生了学生数目变化事件,");
		e.show();
	}
}
