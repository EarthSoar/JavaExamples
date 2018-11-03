package cards_game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;


/**
 *	模拟斗地主游戏：
 *	1.先得造一副扑克牌  红桃A，黑桃A  ...大王，小王
 *	2.接着你得买一副新牌,新派的顺序肯定是正确的
 *	3.洗牌，发牌
 *	4.三人开始玩耍，同时有三张底牌
 *	5.展示自己的牌
 */

public class CardsGame {
	public static void main(String[] args) {
		//用num表示扑克牌中的数字
		ArrayList<String> nums = new ArrayList<>();
		Collections.addAll(nums,"A","2","3","4","5","6","7","8","9","10","J","Q","K");
		
		//用color表示扑克牌中的花色
		ArrayList<String> colors = new ArrayList<>();
		Collections.addAll(colors, "红桃","梅花","黑桃","方片");
		
		//制造一副扑克牌(将数字和花色组合起来)
		Map<Integer,String> cards = new HashMap<>();
		int index = 0; ///给每个扑克牌定个序号index
		for(String number : nums){
			for(String color : colors){
				cards.put(index++, color + number);
			}
		}
		//再把大小王加上，一副完整的扑克就ok了
		cards.put(index++, "大王");
		cards.put(index++, "小王");
		
		//买一副新的扑克牌来玩耍
		ArrayList<Integer> card = new ArrayList<>();
		for(int i = 0; i <= 53; i++){//初始化牌的序号
			card.add(i);
		}
		
		//愉快的玩耍
		//洗牌
		Collections.shuffle(card);

		TreeSet<Integer> player1 = new TreeSet<>();
		TreeSet<Integer> player2 = new TreeSet<>();
		TreeSet<Integer> player3 = new TreeSet<>();
		//拿出三张牌当做底牌
		TreeSet<Integer> itcards = new TreeSet<>();
		
		//发牌
		for(int i = 0; i < card.size(); i++){
			if(i >= card.size() - 3){//把后三张牌当做底牌
				itcards.add(card.get(i));
			}else if(i % 3 == 0){
				player1.add(i);
				
			}else if(i % 3 == 1){
				player2.add(card.get(i));
				
			}else{
				player3.add(card.get(i));
			}
		}
		
		//排序并打印每个人得到的牌
		print("张三",player1,cards);
		print("李四",player2,cards);
		print("王五",player3,cards);
		print("底牌",itcards,cards);
	}


	private static void print(String name, TreeSet<Integer> player, Map<Integer, String> cards) {
		System.out.print(name + ": ");
		//得到三个玩家的牌和底牌
		for(Integer index : player){
			String result = cards.get(index);
			System.out.print(result + " ");
		}
		System.out.println( );
	}
}
