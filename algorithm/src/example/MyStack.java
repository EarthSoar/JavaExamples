package example;
/**
 * 	固定大小数组实现栈
 * @author Willing
 *
 */
public class MyStack {
	private Integer arr[];
	private int size;
	public MyStack() {
		arr = new Integer[10];
	}
	public void push(Integer ele) {
		if(size == arr.length - 1) {
			throw new ArrayIndexOutOfBoundsException("stack is full");
		}
		arr[size++] = ele;
	}
	public Integer pop() {
		if(size == 0) {
			throw new ArrayIndexOutOfBoundsException("stack is empty ");
		}
		int top = arr[--size];
		arr[size] = null;
		return top;
	}
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(11);
		stack.push(22);
		stack.push(33);
		System.out.println(stack.pop());
	}
}

