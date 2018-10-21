/*

假设我现在是球队的教练,我需要安排上场的球员(安排5个).模拟数据存储的案例,模拟上场球员的球衣号码的存储:

Integer[] players = null;

作为一个教练,要安排上场:

1):初始容量为5的线性列表,准备用来存储场上的5个球衣号码.
2):安排5个球员上场:[11,22,33,44,55].
3):查询指定位置的球员的球衣号码是多少.查询索引位置为2的球衣号码是:33.
4):根据球衣号码查询该球员在场上的索引位置. 44球衣号的球员在场上的索引位置是:3.
5):替换场上索引位置为2的球员,替换之后该位置的球衣编号为333. 333把33替换了.
6):替换球衣号码为22的球员,替换之后为222.
7):把场上索引位置为2的球衣罚下场(注意:罚下,没有补位.).
8):按照球员在场上的位置,打印出球衣号码,打印风格:[11,22,33,44,55].

*/
import java.util.Arrays;
public class BaseketballPlayerDemo
{
	private static Integer[] players = null;
	//场上球员的个数
	private static int size = 0;
	public static void main(String[] args){
		init(5);//初始化容量为5
		add(11);
		add(22);
		add(33);
		add(44);
		add(55);//安排这5个球员上场
		//add(66);
		print();
		remove(1);
		print();
		set(1,2222);
		print();
		System.out.println(get(2));//获取索引为2的球员的球员号码
		System.out.println(getIndex(44));//获取44号球员的索引
	}
	//初始化
	public static void init(int initialCapacity){
		players = new Integer[initialCapacity]; 
	}
	//安排球员上场
	public static void add(Integer playerName){
		if(size >= players.length){
			players = Arrays.copyOf(players,size*2);
		}
		players[size] = playerName;
		size++;
	}
	//查询指定位置球员的号码是多少，例如索引位置为2的球员的号码是33
	public static Integer get(int index){
		if(index < 0 || index >= size){
			 throw new IllegalArgumentException("数组越界");
		}
		return players[index];
	}
	//查询球员的索引
	public static int getIndex(Integer playerNum){
		for(int index = 0;index < size; index++){
			if(playerNum.equals(players[index])){
				return index;
			}
		}
		return -1;
	}
	//替换场上索引为index的球员为newPlayerNum
	public static void set(int index,Integer newPlayerNum){
		if(index < 0 || index >= size){
			 throw new IllegalArgumentException("数组越界");
		}
		players[index] = newPlayerNum;
	}
	//替换场上球员号码为oldPlayerNum为newPlayerNum
	public static void update(Integer oldPlayerNum,Integer newPlayerNum){
		players[getIndex(oldPlayerNum)] = newPlayerNum;
	}
	//删除索引为index的号码
	public static void remove(int index){
		if(index < 0 || index >= size){
			 throw new IllegalArgumentException("数组越界");
		}
		for(int i = 0; i < size - 1;i++){
			players[index] = players[index + 1];
		}
		players[size - 1] = null;
		size--;
	}
	//打印出球员的号码
	public static void print(){
		//数组还没有初始化
		if(players == null){
			System.out.println("null");
			return;
		}
		//初始化了，但是没有值，也就是台上还没有球员
		if(size == 0){
			System.out.println("[]");
			return;
		}
		StringBuilder sb = new StringBuilder(size*2 + 1);
		sb.append("[");
		for(int index = 0; index < size; index++){
			sb.append(players[index]);
			if(index != size - 1){
				sb.append(",");
			}else{
				sb.append("]");
			}
		} 
		System.out.println(sb.toString());
	}
}
