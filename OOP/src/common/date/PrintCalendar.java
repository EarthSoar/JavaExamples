package common.date;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class PrintCalendar {
	public static void main(String[] args) {
		//获取今天的时间
		LocalDate date = LocalDate.now();
		//获取今天的月份
		int month = date.getMonthValue();
		//获取今天是这个月的第几天
		int day = date.getDayOfMonth();
		
		//把今天置为这个月第一天
		date = date.minusDays(day - 1);
		
		//获得当天是星期几
		DayOfWeek weekday = date.getDayOfWeek();
		int value = weekday.getValue();
		
		/**
		 * 1.先打印第一行的标题栏
		 * 2.这个月的第一天星期数与标题栏对齐(星期几就打印几个单位的空格)
		 */
		System.out.println("MON TUE WED THU FIR SAT SUN");
		for(int i = 1; i <= value; i++){
			System.out.print("   ");
		}
		
		/**
		 * 打印日历体
		 */
		//循环打印,直到获取的月份不是这个月为止
		while(date.getMonthValue() == month){
			//获取并打印这个月的几号,用三个空格分开
			System.out.printf("%3d",date.getDayOfMonth());
			if(date.getDayOfMonth() == day){
				System.out.print("*");
			}else{
				System.out.print(" ");
			}
			//天数自增1
			date = date.plusDays(1);
			
			//星期一就换行
			if(date.getDayOfWeek().getValue() == 1){
				System.out.println();
			}
		}
		if(date.getDayOfWeek().getValue() != 1){
			System.out.println();
		}
	}
}
