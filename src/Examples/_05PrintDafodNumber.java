package Examples;
//打印所有的水仙花数（153是一个水仙花数，153等于1的平方+5的平方+3的平方)
//水仙花数是一个三位数；
public class _05PrintDafodNumber {
	public static void main(String []args){
		//System.out.println();
		
		for(int i = 100;i < 1000;i++){
			if(IsDafodNumber(i) == 1){
				System.out.println(i);
			}
		}
	}
	static int IsDafodNumber(int num){
		//153
		//取出三位数的十位
		int ten = (num / 10)%10;
		
		//取出三位数的百位
		int hun = num / 100;
		//取出三位数的个位
		int unit = num % 10;
		
		if((ten*ten*ten+hun*hun*hun+unit*unit*unit) == num){
			return 1;
		}else{
			return 0;
		}
	}
}	
