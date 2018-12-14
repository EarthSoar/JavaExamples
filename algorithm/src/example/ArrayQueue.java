package example;

import java.util.Arrays;

/**
 * 	数组实现固定大小的队列
 * @author Willing
 *
 */
public class ArrayQueue {
	private Integer arr[];
	private int size;
	private int head = 0;//队头
	private int end = 0;//队尾
	public ArrayQueue(){
		arr = new Integer[4];
	}
	public void add(Integer ele) {
		if(size == arr.length) {
			throw new RuntimeException("queue is full");
		}
		size++;
		arr[end] = ele;
		end = end == arr.length - 1 ? 0 : end + 1; 
	}
	public Integer poll() {
		if(size == 0) {
			throw new RuntimeException("queue is empty");
		}
		size--;
		int res = arr[head];
		head = head == arr.length - 1 ? 0 : head + 1;
		return res;
	}
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue();
		queue.add(111);
		queue.add(222);
		queue.add(333);
		queue.add(444);
		int res = queue.poll();
		queue.add(555);
		System.out.println(res);
		Integer[] ar = queue.arr;
		System.out.println(Arrays.toString(ar));
	}
}
