package _11collection;

import java.util.ArrayList;

class Gerbil{
	private int gerbilNum;
	public Gerbil(int gerbilNum){
		this.gerbilNum = gerbilNum;
	}
	public void hop(){
		System.out.println(this.gerbilNum + "ÔÚÌøÔ¾");
	}
}
public class Ex1 {
	public static void main(String[] args) {
		ArrayList<Gerbil> list = new ArrayList<>();
		list.add(new Gerbil(1));
		list.add(new Gerbil(3));
		list.add(new Gerbil(2));
		for(int i = 0; i < list.size();i++){
			list.get(i).hop();;
		}
	}
	
}
