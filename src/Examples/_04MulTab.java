package Examples;
//��ӡ9*9�˷��ھ���
public class _04MulTab {
	public static void main(String[]args){
	/*		һ������µ�˫��forѭ��
		for(int i = 1;i < 10;i++){
			for(int j = 1;j <= i;j++){
				System.out.print(j+ "*" + i + "=" + i*j + "\t");
			}
			System.out.println();
		}
	}
	*/
		//method(9);
		print9to9(1,1);//��1*1��ʼ
	}
	
	//ʹ�õݹ飨��ѭ����
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
	
	//ʹ�õݹ飨����ѭ����
	static void print9to9(int i,int j){
		if (i<j) {//���i<j,�Ͱ���i������˳���ӡ
			System.out.print(i+"*"+j+"="+i*j+" ");
			 print9to9(++i, j);
		}else if (j<=9) {//���i<j�������ˣ���j<9ʱ����ӡ���һ�����еģ�Ȼ���ٵݹ��j+1
			System.out.println(i+"*"+j+"="+i*j);
			if (j ==9) {
				return;
			}else {
				print9to9(1, ++j);//�ص����ڰ�i������1.
			}
		}
	}
}