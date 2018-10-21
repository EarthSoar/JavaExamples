/*

��������������ӵĽ���,����Ҫ�����ϳ�����Ա(����5��).ģ�����ݴ洢�İ���,ģ���ϳ���Ա�����º���Ĵ洢:

Integer[] players = null;

��Ϊһ������,Ҫ�����ϳ�:

1):��ʼ����Ϊ5�������б�,׼�������洢���ϵ�5�����º���.
2):����5����Ա�ϳ�:[11,22,33,44,55].
3):��ѯָ��λ�õ���Ա�����º����Ƕ���.��ѯ����λ��Ϊ2�����º�����:33.
4):�������º����ѯ����Ա�ڳ��ϵ�����λ��. 44���ºŵ���Ա�ڳ��ϵ�����λ����:3.
5):�滻��������λ��Ϊ2����Ա,�滻֮���λ�õ����±��Ϊ333. 333��33�滻��.
6):�滻���º���Ϊ22����Ա,�滻֮��Ϊ222.
7):�ѳ�������λ��Ϊ2�����·��³�(ע��:����,û�в�λ.).
8):������Ա�ڳ��ϵ�λ��,��ӡ�����º���,��ӡ���:[11,22,33,44,55].

*/
import java.util.Arrays;
public class BaseketballPlayerDemo
{
	private static Integer[] players = null;
	//������Ա�ĸ���
	private static int size = 0;
	public static void main(String[] args){
		init(5);//��ʼ������Ϊ5
		add(11);
		add(22);
		add(33);
		add(44);
		add(55);//������5����Ա�ϳ�
		//add(66);
		print();
		remove(1);
		print();
		set(1,2222);
		print();
		System.out.println(get(2));//��ȡ����Ϊ2����Ա����Ա����
		System.out.println(getIndex(44));//��ȡ44����Ա������
	}
	//��ʼ��
	public static void init(int initialCapacity){
		players = new Integer[initialCapacity]; 
	}
	//������Ա�ϳ�
	public static void add(Integer playerName){
		if(size >= players.length){
			players = Arrays.copyOf(players,size*2);
		}
		players[size] = playerName;
		size++;
	}
	//��ѯָ��λ����Ա�ĺ����Ƕ��٣���������λ��Ϊ2����Ա�ĺ�����33
	public static Integer get(int index){
		if(index < 0 || index >= size){
			 throw new IllegalArgumentException("����Խ��");
		}
		return players[index];
	}
	//��ѯ��Ա������
	public static int getIndex(Integer playerNum){
		for(int index = 0;index < size; index++){
			if(playerNum.equals(players[index])){
				return index;
			}
		}
		return -1;
	}
	//�滻��������Ϊindex����ԱΪnewPlayerNum
	public static void set(int index,Integer newPlayerNum){
		if(index < 0 || index >= size){
			 throw new IllegalArgumentException("����Խ��");
		}
		players[index] = newPlayerNum;
	}
	//�滻������Ա����ΪoldPlayerNumΪnewPlayerNum
	public static void update(Integer oldPlayerNum,Integer newPlayerNum){
		players[getIndex(oldPlayerNum)] = newPlayerNum;
	}
	//ɾ������Ϊindex�ĺ���
	public static void remove(int index){
		if(index < 0 || index >= size){
			 throw new IllegalArgumentException("����Խ��");
		}
		for(int i = 0; i < size - 1;i++){
			players[index] = players[index + 1];
		}
		players[size - 1] = null;
		size--;
	}
	//��ӡ����Ա�ĺ���
	public static void print(){
		//���黹û�г�ʼ��
		if(players == null){
			System.out.println("null");
			return;
		}
		//��ʼ���ˣ�����û��ֵ��Ҳ����̨�ϻ�û����Ա
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
