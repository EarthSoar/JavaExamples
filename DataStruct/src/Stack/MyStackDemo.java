package Stack;

public class MyStackDemo {
	public static void main(String []args){
		MyStack stack = new MyStack();
		stack.push("willing1");
		stack.push("willing2");
		stack.push("willing3");
		stack.push("willing4");
		stack.pop();
		System.out.println(stack.peek());
	}
}
