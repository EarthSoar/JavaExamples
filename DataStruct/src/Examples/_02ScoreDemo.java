package Examples;
import java.util.Scanner;

//����һ���ٷ��Ƶķ����������Ӧ�ĵȼ���
//90������ A��
//80~89 B��
//70~79 C��
//60~69 D��
//60������ E��

public class _02ScoreDemo {
	static void Judge(double score){
		if(score >= 90){
			System.out.println("A��");
		}else if(score >= 80){
			System.out.println("B��");
		}else if(score >= 70){
			System.out.println("C��");
		}else if(score >= 60){
			System.out.println("D��");
		}else{
			System.out.println("E��");
		}
	}
	public static void main(String []args){
		System.out.println("������һ��������");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		double  score = scanner.nextDouble();
		
		Judge(score);
	}
}
