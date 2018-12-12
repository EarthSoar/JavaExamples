package example;

import java.util.Stack;

/**
 *	两个栈构成一个队列
 */
public class TwoStackQueue {
	private Stack<Integer> stackPush;
	private Stack<Integer> stackPop;
	public TwoStackQueue() {
		stackPop = new Stack<>();
		stackPush = new Stack<>();
	}
	public void add(Integer ele) {
		stackPush.push(ele);
	}
	
	public int poll() {
		//stackPush 一次必须到完,并且倒的时候必须保证stackPop为空
		if(stackPush.empty() && stackPop.empty()) {
			throw new RuntimeException("queue is empty");
		}else if(stackPop.empty()){
			while(!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
	}
	public int peek() {
		//stackPush 一次必须到完,并且倒的时候必须保证stackPop为空
		if(stackPush.empty() && stackPop.empty()) {
			throw new RuntimeException("queue is empty");
		}else if(stackPop.empty()){
			while(!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.peek();
	}
	public static void main(String[] args) {
		TwoStackQueue queue = new TwoStackQueue();
		queue.add(111);
		queue.add(222);
		queue.add(333);
		queue.peek();
		int res = queue.poll();
		System.out.println(res);
	}
}

