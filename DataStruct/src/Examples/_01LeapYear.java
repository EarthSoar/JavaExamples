package Examples;
import java.util.Scanner;


//1����д�����жϸ�����ĳ������Ƿ������ꡣ
//������жϹ������£�
//��1����ĳ������ܱ�4���������ܱ�100�������������ꡣ
//��2����ĳ������ܱ�400��������Ҳ�����ꡣ
public class _01LeapYear {
	static int IsLeap(int year){    //IsYear()���������жϸ����ǲ�������
		if((year%4 == 0&&year%100!= 0)||year % 400 == 0){
			return 1;
		}
		return 0;
	}
	public static void main(String[] args) {
		System.out.println("��������ݣ�"); 
		
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
