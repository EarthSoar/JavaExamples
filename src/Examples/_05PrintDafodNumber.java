package Examples;
//��ӡ���е�ˮ�ɻ�����153��һ��ˮ�ɻ�����153����1��ƽ��+5��ƽ��+3��ƽ��)
//ˮ�ɻ�����һ����λ����
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
		//ȡ����λ����ʮλ
		int ten = (num / 10)%10;
		
		//ȡ����λ���İ�λ
		int hun = num / 100;
		//ȡ����λ���ĸ�λ
		int unit = num % 10;
		
		if((ten*ten*ten+hun*hun*hun+unit*unit*unit) == num){
			return 1;
		}else{
			return 0;
		}
	}
}	
