package student;

/**
	1.定义一个事件源组件
	创建一个类，具有无参和带参的构造方法分别构造一个默认课程和一个指定名称的课程属性包括：课程名，选课学生，
	招生最大数。方法包括：返回课程名，添加新学生，返回选课的学生人数，返回招生限额以及设置新的招生限额。
	2.添加和删除监听器的方法定义事件组，当超出招生限额时，触发招生事件
	包括关于事件的信息：招生限额和选课学生人数。 监听接口中要定义处理招生事件的方法.				
	3.定义测试程序利用源组件创建课程设置招生限额为2,创建并注册招生监听器，向课程中添加三个学生，
	当添加第三个学生时触发招生事件，课程对象调用监听器中的方法处理招生事件，显示课程的学生人数和招生限额。 
 */
public class Test {
	public static void main(String[] args) {
		Course course = new Course();
		course.setMaxLimit(2);
		course.addLimitListener(new StudentListenerImpl());
		course.addStudent();
		course.show();
		course.addStudent();
		course.show();
		course.addStudent();
		course.show();
	}
}
