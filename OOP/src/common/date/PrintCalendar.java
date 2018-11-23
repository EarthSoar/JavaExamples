package common.date;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class PrintCalendar {
	public static void main(String[] args) {
		//��ȡ�����ʱ��
		LocalDate date = LocalDate.now();
		//��ȡ������·�
		int month = date.getMonthValue();
		//��ȡ����������µĵڼ���
		int day = date.getDayOfMonth();
		
		//�ѽ�����Ϊ����µ�һ��
		date = date.minusDays(day - 1);
		
		//��õ��������ڼ�
		DayOfWeek weekday = date.getDayOfWeek();
		int value = weekday.getValue();
		
		/**
		 * 1.�ȴ�ӡ��һ�еı�����
		 * 2.����µĵ�һ�������������������(���ڼ��ʹ�ӡ������λ�Ŀո�)
		 */
		System.out.println("MON TUE WED THU FIR SAT SUN");
		for(int i = 1; i <= value; i++){
			System.out.print("   ");
		}
		
		/**
		 * ��ӡ������
		 */
		//ѭ����ӡ,ֱ����ȡ���·ݲ��������Ϊֹ
		while(date.getMonthValue() == month){
			//��ȡ����ӡ����µļ���,�������ո�ֿ�
			System.out.printf("%3d",date.getDayOfMonth());
			if(date.getDayOfMonth() == day){
				System.out.print("*");
			}else{
				System.out.print(" ");
			}
			//��������1
			date = date.plusDays(1);
			
			//����һ�ͻ���
			if(date.getDayOfWeek().getValue() == 1){
				System.out.println();
			}
		}
		if(date.getDayOfWeek().getValue() != 1){
			System.out.println();
		}
	}
}
