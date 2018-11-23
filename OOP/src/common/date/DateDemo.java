package common.date;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateDemo {
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		System.out.println(now);
		//�����Ǽ��·�
		System.out.println("�������"+now.getMonthValue()+"��");
		//�����Ǽ���
		System.out.println("������"+now.getDayOfMonth()+"��");
		//�������ڼ�,����1��Ӧ����һ��7��Ӧ����������
		System.out.println("��������"+now.getDayOfWeek().getValue());
		
		//�ѽ�������Ϊ����µ�һ�ţ���ȥ�����Ǽ���
		now = now.minusDays(now.getDayOfMonth() - 1);
		System.out.println(now);

		DayOfWeek week = now.getDayOfWeek();
		int value = week.getValue();
		System.out.println(value);
	}
}
