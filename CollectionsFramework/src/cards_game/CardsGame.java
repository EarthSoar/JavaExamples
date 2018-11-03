package cards_game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;


/**
 *	ģ�⶷������Ϸ��
 *	1.�ȵ���һ���˿���  ����A������A  ...������С��
 *	2.���������һ������,���ɵ�˳��϶�����ȷ��
 *	3.ϴ�ƣ�����
 *	4.���˿�ʼ��ˣ��ͬʱ�����ŵ���
 *	5.չʾ�Լ�����
 */

public class CardsGame {
	public static void main(String[] args) {
		//��num��ʾ�˿����е�����
		ArrayList<String> nums = new ArrayList<>();
		Collections.addAll(nums,"A","2","3","4","5","6","7","8","9","10","J","Q","K");
		
		//��color��ʾ�˿����еĻ�ɫ
		ArrayList<String> colors = new ArrayList<>();
		Collections.addAll(colors, "����","÷��","����","��Ƭ");
		
		//����һ���˿���(�����ֺͻ�ɫ�������)
		Map<Integer,String> cards = new HashMap<>();
		int index = 0; ///��ÿ���˿��ƶ������index
		for(String number : nums){
			for(String color : colors){
				cards.put(index++, color + number);
			}
		}
		//�ٰѴ�С�����ϣ�һ���������˿˾�ok��
		cards.put(index++, "����");
		cards.put(index++, "С��");
		
		//��һ���µ��˿�������ˣ
		ArrayList<Integer> card = new ArrayList<>();
		for(int i = 0; i <= 53; i++){//��ʼ���Ƶ����
			card.add(i);
		}
		
		//������ˣ
		//ϴ��
		Collections.shuffle(card);

		TreeSet<Integer> player1 = new TreeSet<>();
		TreeSet<Integer> player2 = new TreeSet<>();
		TreeSet<Integer> player3 = new TreeSet<>();
		//�ó������Ƶ�������
		TreeSet<Integer> itcards = new TreeSet<>();
		
		//����
		for(int i = 0; i < card.size(); i++){
			if(i >= card.size() - 3){//�Ѻ������Ƶ�������
				itcards.add(card.get(i));
			}else if(i % 3 == 0){
				player1.add(i);
				
			}else if(i % 3 == 1){
				player2.add(card.get(i));
				
			}else{
				player3.add(card.get(i));
			}
		}
		
		//���򲢴�ӡÿ���˵õ�����
		print("����",player1,cards);
		print("����",player2,cards);
		print("����",player3,cards);
		print("����",itcards,cards);
	}


	private static void print(String name, TreeSet<Integer> player, Map<Integer, String> cards) {
		System.out.print(name + ": ");
		//�õ�������ҵ��ƺ͵���
		for(Integer index : player){
			String result = cards.get(index);
			System.out.print(result + " ");
		}
		System.out.println( );
	}
}
