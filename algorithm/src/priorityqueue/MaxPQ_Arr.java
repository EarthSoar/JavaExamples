package priorityqueue;

public class MaxPQ_Arr {
	//1.无序数组
	private static Integer[] arr;
	private static int size = 0;
	public MaxPQ_Arr() {
		this(10);
	}
	public MaxPQ_Arr(int max) {
		arr = new Integer[max];
	}
	
	//返回最大元素
	public Integer max() {
		int minIndex = 0;
		for(int i = 1; i < size; i++) {
			if(arr[minIndex] > arr[i]) {
				minIndex = i;
			}
		}
		swap(arr,0,minIndex);
		return  arr[0];
	}
	
	//插入元素
	public void Insert(Integer value) {
		if(arr.length == size) {
			throw new ArrayIndexOutOfBoundsException("队列已经满了,不能插入了");
		}
		arr[size++] = value;
	}
	//弹出队列中的最大元素 并返回
	public Integer delMax() {
		int maxIndex = 0;
		for(int i = 1; i < size; i++) {  //类似于选择排序
			if(arr[maxIndex] < arr[i]) {
				maxIndex = i;
			}
		}
		swap(arr,0,maxIndex);
		int max = arr[0];
		arr[0] = null;
		size--;
		return max;
	}
	public void swap(Integer[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public int size() {
		return size;
	}
	
	//For test
	public static void main(String[] args) {
		MaxPQ_Arr m = new MaxPQ_Arr();
		m.Insert(1);
		m.Insert(2);
		m.Insert(3);
		m.Insert(-1);
		m.Insert(8);
		m.Insert(0);
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] != null) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
		int max = m.delMax();
		System.out.println(max);
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] != null) {
				System.out.print(arr[i] + " ");
			}
		}
	}
}
