package list;
import java.util.*;
//ջ
//ʵ��ջ�Ĵ洢���ײ�����������ţ�Ҳ������������
public class StackDemo {
	public static void main(String []args){
		Stack<String> s1 = new Stack<String>();
		//push�ǽ���ѹջ
		s1.push("D");
		s1.push("C");
		//peek()���ص���ջ��Ԫ��
		System.out.println(s1.peek());
		System.out.println(s1.isEmpty());
		s1.pop();
		System.out.println(s1.peek());
		
		ArrayDeque<String>  a = new ArrayDeque<String>();
		a.push("111");
		a.push("222");
		System.out.println(a.peek());
		
	}
}
