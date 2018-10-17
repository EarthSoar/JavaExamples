package Aarray;

import java.util.Arrays;

public class PlayerList {
	//存储场上球员的球衣号码
	private static Integer[] players = null;
	//场上球员的个数
	private static int size = 0;
	//初始容量为
	
	//1):初始容量为5的线性列表,准备用来存储场上的5个球衣号码.
	public static void init(int initialCapacity ){
		players = new Integer[initialCapacity];
	}
	
	//2):安排5个球员上场:[11,22,33,44,55].
	public static void add(Integer playerNum){
		
		if(size == players.length){   //存满了，数组自动扩容,扩容机制为2倍
			Integer[] temp = Arrays.copyOf(players,players.length*2);
			players = temp;
		}
			
		players[size] = playerNum;
		size++;
	}
	
	//3):查询指定位置的球员的球衣号码是多少.查询索引位置为2的球衣号码是:33.
	public static Integer get(int index){
		if(index < 0 || index >= size){//索引越界了
			throw new IllegalArgumentException("索引越界");
		}
		return players[index];
	}
	
	//4):根据球衣号码查询该球员在场上的索引位置. 44球衣号的球员在场上的索引位置是:3.
	public static Integer getIndex(Integer playerNum){
		for(int index = 0;index < size;index++){
			if(playerNum.equals(players[index])){
				return index;  //找到该球员的号码，返回数组的索引.
			}
		}
		return -1;//没有找到返回-1；
	}
	
	//5):替换场上索引位置为2的球员,替换之后该位置的球衣编号为333. 333把33替换了.
	public static void set(int index,Integer newPlayerNum) {
		if(index < 0 || index >= size){//索引越界了
			throw new IllegalArgumentException("索引越界");
		}
		players[index] = newPlayerNum;
	}
	
	//6):替换球衣号码为22的球员,替换之后为222.
	public static void update(Integer oldPlayerNum,Integer newPlayerNum){
		int index = getIndex(oldPlayerNum);
		if(index >= 0){
			set(index,newPlayerNum);
		}
	}
	
	//7):把场上索引位置为2的球衣罚下场(注意:罚下,没有补位.).
	public static void delete(int index){
		if(index < 0 || index >= size){//索引越界了
			throw new IllegalArgumentException("索引越界");
		}
		for(int i = index;i < size -1 ;i++){   //size - 1  防止数组越界，最后把索引size-1置为null
			players[index] = players[index + 1];//把index+1的移动到index
		}
		//把index 置为null 
		players[size - 1] = null ;
		//数组长度 减1
		size--;
	}
	
	//8):按照球员在场上的位置,打印出球衣号码,打印风格:[11,22,33,44,55].
	public static void print(){
		if(players == null){
			System.out.println("null");
			return;//结束方法
		}
		if(size == 0){
			System.out.println("[]");
			return;
		}
		StringBuilder sb = new StringBuilder(size*2 + 1);
		sb.append("[");
		for(int index = 0;index < size ;index++){
			sb.append(players[index]);
			if(index != size - 1){//若数组不是最后一个元素
				sb.append(",");
			}else{
				sb.append("]");
			}
		}
		System.out.println(sb.toString());
	}
}
