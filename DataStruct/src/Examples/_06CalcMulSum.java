<<<<<<< HEAD
package Examples;

import java.util.Scanner;
//��a+aa+aaa+.......+aaaaaaaaa=?
//����aΪ1��9֮�е�һ����������ҲҪ����ָ����
public class _06CalcMulSum {
	public static void main(String []args){
		int a = 0;
		int n = 0;//����
		int sum = 0;//���
		
		System.out.print("����a��ֵ;");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		System.out.println("������������");
		n = sc.nextInt();
		
//		for(int i = 0; i < n;i++){
//			sum += a;
//			a = 10*a + a;  //a����һ��.   2,22,222,2222
//		}
		 sum = SUM(a,n);
		
		System.out.println("sum = " + sum );
	}
	//�ݹ鷽��
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
//��a+aa+aaa+.......+aaaaaaaaa=?
//����aΪ1��9֮�е�һ����������ҲҪ����ָ����
public class _06CalcMulSum {
	public static void main(String []args){
		int a = 0;
		int n = 0;//����
		int sum = 0;//���
		
		System.out.print("����a��ֵ;");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		System.out.println("������������");
		n = sc.nextInt();
		
//		for(int i = 0; i < n;i++){
//			sum += a;
//			a = 10*a + a;  //a����һ��.   2,22,222,2222
//		}
		 sum = SUM(a,n);
		
		System.out.println("sum = " + sum );
	}
	//�ݹ鷽��
	static int SUM(int a,int n){ //2,4
		if(n > 1){
			return a*n + SUM(a,n-1)*10;
		}
		return a;
		
	}
}
>>>>>>> 1a766867ea941069d0566b6c99e8590978a39b64
