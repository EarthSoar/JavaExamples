package Aarray;

public class FootballPlayerDemo {
	public static void main(String[]args){
		PlayerList.init(5);//初始化线性数组
		PlayerList.add(1);//安排1号球员上场，索引为0
		PlayerList.add(2);//安排2号球员上场，索引为1
		PlayerList.add(3);
		PlayerList.add(4);
		PlayerList.add(5);//安排5号球员上场，索引为4.  size表示场上球员的个数，此时size = 5;
		PlayerList.add(6);
		PlayerList.add(7);
		PlayerList.add(8);
		PlayerList.add(9);
		PlayerList.add(10);
		PlayerList.add(11);//安排5号球员上场，索引为10.  size表示场上球员的个数，此时size = 11;
		PlayerList.print();//格式打印球员在场上的位置。	
		
		System.out.println(PlayerList.get(2));//查询索引为2的球员的球衣号码是多少
		System.out.println(PlayerList.getIndex(44));//查询球员号为44的索引
		
		PlayerList.set(2,333);//让333号球员替换索引位置为2的球员
		//print();
		
		PlayerList.update(22,222);//把22号球员替换成222号
		PlayerList.print();
		
		PlayerList.delete(2);//把索引为2的球员罚下场
		PlayerList.print();
	}
}
