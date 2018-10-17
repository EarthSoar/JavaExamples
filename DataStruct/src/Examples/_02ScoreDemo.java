package Examples;
import java.util.Scanner;

//给定一个百分制的分数，输出相应的等级。
//90分以上 A级
//80~89 B级
//70~79 C级
//60~69 D级
//60分以下 E级

public class _02ScoreDemo {
	static void Judge(double score){
		if(score >= 90){
			System.out.println("A级");
		}else if(score >= 80){
			System.out.println("B级");
		}else if(score >= 70){
			System.out.println("C级");
		}else if(score >= 60){
			System.out.println("D级");
		}else{
			System.out.println("E级");
		}
	}
	public static void main(String []args){
		System.out.println("请输入一个分数：");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		double  score = scanner.nextDouble();
		
		Judge(score);
	}
}
