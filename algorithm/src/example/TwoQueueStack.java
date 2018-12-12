package example;

import java.util.LinkedList;
import java.util.Queue;

/**
 *	两个队列构成栈
 */
public class TwoQueueStack {
	private Queue<Integer> queue;
	private Queue<Integer> help;
	public TwoQueueStack() {
		queue = new LinkedList<>();
		help = new LinkedList<>();
	}
	public void push(Integer ele) {
		queue.add(ele);
	}
	
	public int pop() {
		if(queue.isEmpty()) {
			throw new RuntimeException("stack id empty");
		}
		//把队列头部弹出,直到里面再剩一个
		while(queue.size() > 1) {
			help.add(queue.poll());
		}
		int res = queue.poll();
		swap();
		return res;
	}
	public int peek() {
		if(queue.isEmpty()) {
			throw new RuntimeException("stack id empty");
		}
		while(queue.size() > 1) {
			help.add(queue.poll());
		}
		int res = queue.poll();
		help.add(res);
		swap();
		return res;
	}
	
	//交换help和queue的引用
	private void swap() {
		Queue<Integer> temp = help;
		help = queue;
		queue = temp;
	}
	public static void main(String[] args) {
		TwoQueueStack stack = new TwoQueueStack();
		stack.push(11);
		stack.push(22);
		stack.push(33);
		int res = stack.pop();
		System.out.println(res);
	}
}
