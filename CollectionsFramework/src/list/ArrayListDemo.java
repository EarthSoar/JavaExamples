package list;
import java.util.*;
public class ArrayListDemo {
	public static void main(String []args){
		ArrayList<String> a = new ArrayList<String>();
		
		//��
		a.add("A");
		a.add("B");
		a.add("CC");
		a.add("DDD");
		System.out.println(a);
		
		//ɾ
		a.remove(0);
		System.out.println(a);
		a.remove("DDD");
		System.out.println(a);
		
		//��
		a.set(0, "��");
		System.out.println(a);
		
		//��
		System.out.println(a.size());
	}
}
