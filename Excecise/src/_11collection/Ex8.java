package _11collection;

import java.util.ArrayList;
import java.util.Iterator;

//�޸���ϰ1���Ա����hopʹ��Iterator����List
public class Ex8 {
	public static void main(String[] args) {
		ArrayList<Gerbil> list1 = new ArrayList<>();
		list1.add(new Gerbil(1));
		list1.add(new Gerbil(3));
		list1.add(new Gerbil(2));
		Iterator<Gerbil> it = list1.iterator();
		while(it.hasNext()){
			it.next().hop();
		}
	}
}
