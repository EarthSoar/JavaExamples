package Aarray;

public class ArrayListDemo {
	
	public static void main(String []args){
		MyArrayList list = new MyArrayList(5);
		list.add(11);
		list.add(true);
		System.out.println(list.size());
		System.out.println(list.toString());
		list.delete(0);
		System.out.println(list.toString());
		list.clear();
		System.out.println(list.toString());
	}
}
