package example;

import java.util.Stack;
/**
 * 	该栈随时可以返回栈最小值
 * @author Willing
 *
 */
public class GetMinStack {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	public GetMinStack() {
		stackData = new Stack<>();
		stackMin = new Stack<>();
	}
	
	public void push(Integer newNum) {
		//stackMin为空直接压入
		if(stackMin.isEmpty()) {
			stackMin.push(newNum);
			//新加的数不大于stackMin栈顶元素,压入stackMin
		} else if(newNum <= this.getMin()) {
			stackMin.push(newNum);
		}
		//每次压入stackData栈中
		stackData.push(newNum);
	}
	public Integer pop() {
		if(stackData.isEmpty()) {
			throw new RuntimeException("stack is empty");
		}
		int value = stackData.pop();
		if(value == this.getMin()) {
			stackMin.pop();
		}
		return value;
	}
	public Integer getMin() {
		if(stackMin.isEmpty()) {
			throw new RuntimeException("stack is empty");
		}
		return stackMin.peek();
	}
	
	public static void main(String[] args) {
		GetMinStack stack = new GetMinStack();
		stack.push(11);
		stack.push(1);
		stack.push(22);
		System.out.println(stack.pop());
		System.out.println(stack.getMin());
	}
}
