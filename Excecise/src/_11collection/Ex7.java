package _11collection;

import java.util.ArrayList;
import java.util.List;

/**
 *����һ���࣬Ȼ�󴴽�һ���������Ķ�����й���ʼ�������顣ͨ��ʹ��subList()�������������List�Ӽ���Ȼ�������List
 *��ɾ������Ӽ�
 */
class Test{
//	static int count;
//	int a = count++;
//	public String toString(){
//		return String.valueOf(a);
//	}
	int id;
	Test(int id){
		this.id = id;
	}
	@Override
	public String toString() {
		return id + "";
	}
}
public class Ex7 {
	public static void main(String[] args) {
		Test[] t = new Test[10];
		for(int i = 0; i < t.length; i++){
			t[i] = new Test(i);
		}
		List<Test> list = new ArrayList<>();
		for(Test m : t){
			list.add(m);
		}
		System.out.println(list);
		
		List<Test> sub = list.subList(1, 4);
		System.out.println(sub);
		list.removeAll(sub);
		System.out.println(list);
	} 
}
