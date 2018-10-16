package Aarray;

import java.util.Arrays;

public class PlayerList {
	//�洢������Ա�����º���
	private static Integer[] players = null;
	//������Ա�ĸ���
	private static int size = 0;
	//��ʼ����Ϊ
	
	//1):��ʼ����Ϊ5�������б�,׼�������洢���ϵ�5�����º���.
	public static void init(int initialCapacity ){
		players = new Integer[initialCapacity];
	}
	
	//2):����5����Ա�ϳ�:[11,22,33,44,55].
	public static void add(Integer playerNum){
		
		if(size == players.length){   //�����ˣ������Զ�����,���ݻ���Ϊ2��
			Integer[] temp = Arrays.copyOf(players,players.length*2);
			players = temp;
		}
			
		players[size] = playerNum;
		size++;
	}
	
	//3):��ѯָ��λ�õ���Ա�����º����Ƕ���.��ѯ����λ��Ϊ2�����º�����:33.
	public static Integer get(int index){
		if(index < 0 || index >= size){//����Խ����
			throw new IllegalArgumentException("����Խ��");
		}
		return players[index];
	}
	
	//4):�������º����ѯ����Ա�ڳ��ϵ�����λ��. 44���ºŵ���Ա�ڳ��ϵ�����λ����:3.
	public static Integer getIndex(Integer playerNum){
		for(int index = 0;index < size;index++){
			if(playerNum.equals(players[index])){
				return index;  //�ҵ�����Ա�ĺ��룬�������������.
			}
		}
		return -1;//û���ҵ�����-1��
	}
	
	//5):�滻��������λ��Ϊ2����Ա,�滻֮���λ�õ����±��Ϊ333. 333��33�滻��.
	public static void set(int index,Integer newPlayerNum) {
		if(index < 0 || index >= size){//����Խ����
			throw new IllegalArgumentException("����Խ��");
		}
		players[index] = newPlayerNum;
	}
	
	//6):�滻���º���Ϊ22����Ա,�滻֮��Ϊ222.
	public static void update(Integer oldPlayerNum,Integer newPlayerNum){
		int index = getIndex(oldPlayerNum);
		if(index >= 0){
			set(index,newPlayerNum);
		}
	}
	
	//7):�ѳ�������λ��Ϊ2�����·��³�(ע��:����,û�в�λ.).
	public static void delete(int index){
		if(index < 0 || index >= size){//����Խ����
			throw new IllegalArgumentException("����Խ��");
		}
		for(int i = index;i < size -1 ;i++){   //size - 1  ��ֹ����Խ�磬��������size-1��Ϊnull
			players[index] = players[index + 1];//��index+1���ƶ���index
		}
		//��index ��Ϊnull 
		players[size - 1] = null ;
		//���鳤�� ��1
		size--;
	}
	
	//8):������Ա�ڳ��ϵ�λ��,��ӡ�����º���,��ӡ���:[11,22,33,44,55].
	public static void print(){
		if(players == null){
			System.out.println("null");
			return;//��������
		}
		if(size == 0){
			System.out.println("[]");
			return;
		}
		StringBuilder sb = new StringBuilder(size*2 + 1);
		sb.append("[");
		for(int index = 0;index < size ;index++){
			sb.append(players[index]);
			if(index != size - 1){//�����鲻�����һ��Ԫ��
				sb.append(",");
			}else{
				sb.append("]");
			}
		}
		System.out.println(sb.toString());
	}
}
