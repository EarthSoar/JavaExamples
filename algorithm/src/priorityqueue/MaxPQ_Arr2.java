package priorityqueue;

public class MaxPQ_Arr2 {
	// 有序数组
	private static Integer[] arr;
	private static int size = 0;

	public MaxPQ_Arr2() {
		this(10);
	}

	public MaxPQ_Arr2(int max) {
		arr = new Integer[max];
	}

	// 返回最大元素
	public Integer max() {
		Integer ele = arr[--size];
		return ele;
	}

	// 插入元素
	public void Insert(Integer value) {
		arr[size++] = value;
		
		for(int i = size - 1;i >= 1 && arr[i - 1] > arr[i]; i--) {
			swap(arr,i -1 ,i);
		}
	}

	// 弹出队列中的最大元素 并返回
	public Integer delMax() {
		Integer ele = arr[--size];
		arr[size] = null;
		return ele;
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

	// For test
	public static void main(String[] args) {
		MaxPQ_Arr2 m2 = new MaxPQ_Arr2();
		m2.Insert(1);
		m2.Insert(2);
		m2.Insert(3);
		m2.Insert(-1);
		m2.Insert(8);
		m2.Insert(0);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
		int max = m2.delMax();
		System.out.println(max);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				System.out.print(arr[i] + " ");
			}
		}
	}
}
