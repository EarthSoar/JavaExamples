package list;
import java.util.*;
//栈
//实现栈的存储，底层可以用数组存放，也可以用链表存放
public class StackDemo {
	public static void main(String []args){
		Stack<String> s1 = new Stack<String>();
		//push是进行压栈
		s1.push("D");
		s1.push("C");
		//peek()返回的是栈顶元素
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
