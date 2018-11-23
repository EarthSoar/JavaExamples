package common.date;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateDemo {
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		System.out.println(now);
		//今天是几月份
		System.out.println("这个月是"+now.getMonthValue()+"月");
		//今天是几号
		System.out.println("今天是"+now.getDayOfMonth()+"号");
		//今天星期几,星期1对应星期一，7对应的是星期天
		System.out.println("今天星期"+now.getDayOfWeek().getValue());
		
		//把今天设置为这个月的一号，减去几就是几号
		now = now.minusDays(now.getDayOfMonth() - 1);
		System.out.println(now);

		DayOfWeek week = now.getDayOfWeek();
		int value = week.getValue();
		System.out.println(value);
	}
}
