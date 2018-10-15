package Examples;
//打印9*9乘法口诀表
public class _04MulTab {
	public static void main(String[]args){
	/*		一般情况下的双层for循环
		for(int i = 1;i < 10;i++){
			for(int j = 1;j <= i;j++){
				System.out.print(j+ "*" + i + "=" + i*j + "\t");
			}
			System.out.println();
		}
	}
	*/
		//method(9);
		print9to9(1,1);//从1*1开始
	}
	
	//使用递归（带循环）
//	static void method(int i){
//		if(i == 0){
//			return ;
//		}
//		method(i - 1);
//		for(int j = 1;j <= i;j++){
//			System.out.print(j + "*" + i + "=" + i*j +"\t");
//		}
//		System.out.println();
//	}
	
	//使用递归（不带循环）
	static void print9to9(int i,int j){
		if (i<j) {//如果i<j,就按照i递增的顺序打印
			System.out.print(i+"*"+j+"="+i*j+" ");
			 print9to9(++i, j);
		}else if (j<=9) {//如果i<j不成立了，且j<9时，打印最后一个换行的，然后再递归把j+1
			System.out.println(i+"*"+j+"="+i*j);
			if (j ==9) {
				return;
			}else {
				print9to9(1, ++j);//重点在于把i重新置1.
			}
		}
	}
}