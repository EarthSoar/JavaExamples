package Examples;
import java.util.Scanner;


//1，编写程序，判断给定的某个年份是否是闰年。
//闰年的判断规则如下：
//（1）若某个年份能被4整除但不能被100整除，则是闰年。
//（2）若某个年份能被400整除，则也是闰年。
public class _01LeapYear {
	static int IsLeap(int year){    //IsYear()方法用来判断该年是不是闰年
		if((year%4 == 0&&year%100!= 0)||year % 400 == 0){
			return 1;
		}
		return 0;
	}
	public static void main(String[] args) {
		System.out.println("请输入年份："); 
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int year = scanner.nextInt();
		
		int ret = IsLeap(year);
		
		if(ret == 1){
			System.out.println(year + "is a leap year!");
		}else{
			System.out.println(year + "is not a leap year");
		}
	}
}
