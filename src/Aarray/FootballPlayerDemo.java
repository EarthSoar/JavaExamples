package Aarray;

public class FootballPlayerDemo {
	public static void main(String[]args){
		PlayerList.init(5);//��ʼ����������
		PlayerList.add(1);//����1����Ա�ϳ�������Ϊ0
		PlayerList.add(2);//����2����Ա�ϳ�������Ϊ1
		PlayerList.add(3);
		PlayerList.add(4);
		PlayerList.add(5);//����5����Ա�ϳ�������Ϊ4.  size��ʾ������Ա�ĸ�������ʱsize = 5;
		PlayerList.add(6);
		PlayerList.add(7);
		PlayerList.add(8);
		PlayerList.add(9);
		PlayerList.add(10);
		PlayerList.add(11);//����5����Ա�ϳ�������Ϊ10.  size��ʾ������Ա�ĸ�������ʱsize = 11;
		PlayerList.print();//��ʽ��ӡ��Ա�ڳ��ϵ�λ�á�	
		
		System.out.println(PlayerList.get(2));//��ѯ����Ϊ2����Ա�����º����Ƕ���
		System.out.println(PlayerList.getIndex(44));//��ѯ��Ա��Ϊ44������
		
		PlayerList.set(2,333);//��333����Ա�滻����λ��Ϊ2����Ա
		//print();
		
		PlayerList.update(22,222);//��22����Ա�滻��222��
		PlayerList.print();
		
		PlayerList.delete(2);//������Ϊ2����Ա���³�
		PlayerList.print();
	}
}
