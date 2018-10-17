<<<<<<< HEAD
package Examples;

import java.util.Scanner;
//求a+aa+aaa+.......+aaaaaaaaa=?
//其中a为1至9之中的一个数，项数也要可以指定。
public class _06CalcMulSum {
	public static void main(String []args){
		int a = 0;
		int n = 0;//项数
		int sum = 0;//结果
		
		System.out.print("输入a的值;");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		System.out.println("请输入项数：");
		n = sc.nextInt();
		
//		for(int i = 0; i < n;i++){
//			sum += a;
//			a = 10*a + a;  //a的下一项.   2,22,222,2222
//		}
		 sum = SUM(a,n);
		
		System.out.println("sum = " + sum );
	}
	//递归方法
	static int SUM(int a,int n){ //2,4
		if(n > 1){
			return a*n + SUM(a,n-1)*10;
		}
		return a;
		
	}
}
=======
package Examples;

import java.util.Scanner;
//求a+aa+aaa+.......+aaaaaaaaa=?
//其中a为1至9之中的一个数，项数也要可以指定。
public class _06CalcMulSum {
	public static void main(String []args){
		int a = 0;
		int n = 0;//项数
		int sum = 0;//结果
		
		System.out.print("输入a的值;");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		System.out.println("请输入项数：");
		n = sc.nextInt();
		
//		for(int i = 0; i < n;i++){
//			sum += a;
//			a = 10*a + a;  //a的下一项.   2,22,222,2222
//		}
		 sum = SUM(a,n);
		
		System.out.println("sum = " + sum );
	}
	//递归方法
	static int SUM(int a,int n){ //2,4
		if(n > 1){
			return a*n + SUM(a,n-1)*10;
		}
		return a;
		
	}
}
>>>>>>> 1a766867ea941069d0566b6c99e8590978a39b64
