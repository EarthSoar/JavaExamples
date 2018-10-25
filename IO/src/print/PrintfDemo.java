package print;

public class PrintfDemo {
	public static void main(String[] args){
		//java的格式化打印，printf
		String format = "姓名:%s,性别：%s";
		Object[]data = {"小明","男"};
		System.out.printf(format, data);

		System.out.println();
		
		//简化版,和C语言很相似
		System.out.printf("姓名:%s,性别：%s", "小明","男");
	}
}
