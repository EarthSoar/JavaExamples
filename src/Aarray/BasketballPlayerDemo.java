package Aarray;


public class BasketballPlayerDemo {

	public static void main(String[]args){
		PlayerList.init(5);//��ʼ����������
		PlayerList.add(11);//����11����Ա�ϳ�������Ϊ0
		PlayerList.add(22);//����22����Ա�ϳ�������Ϊ1
		PlayerList.add(33);
		PlayerList.add(44);
		PlayerList.add(55);//����55����Ա�ϳ�������Ϊ4.  size��ʾ������Ա�ĸ�������ʱsize = 5;
		//add(66);
		
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
