package Examples;

//编写程序求1+3+5+7+……+99 的和值。

public class _03Sum {
	public static void main(String[] args){
	/*	int sum = 0;
		for(int i = 1;i <= 99;i++){
			sum += i;
		}
	*/
	/*	int sum = 0;
		int i = 1;
		while(i<= 99){
			sum += i;
			i++;
		}
	*/
	/*  int sum = 0;
		int i = 1;
		do{
			sum = sum + i;
			i++;
		}while(i <= 99);
	*/
		int sum = funt(99);
		System.out.println("sum = "+ sum);//4950
	}
	static int funt(int num){
		if(num > 1){
			return num + funt(num - 1);
		}
		return 1;
	}
}
