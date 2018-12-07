package priorityqueue;

public class MaxPQ_peak {
	private static Integer[] arr;
	private static int size = 0;

	public MaxPQ_peak() {
		this(10);
	}

	public MaxPQ_peak(int max) {
		arr = new Integer[max];
	}

	public void swim(int index) {
		while(index > 1) {
			int k = index / 2;
			if(arr[k] < arr[index]) {
				swap(arr,k,index);
			}
			index = k;
		}
	}
	public void sink(int index) {
		while(index*2 <= size) {
			int k = index*2;
			 if( k < size && arr[k] < arr[k + 1]) {
				 k++;
			 }
			 if(arr[index] >= arr[k]) {
				 break;
			 }
			 swap(arr,k,index);
			 index = k;
		}
	}
	
	// 返回最大元素
	public Integer max() {
		return arr[1];
	}

	// 插入元素
	public void Insert(Integer value) {
		arr[++size] = value;
		swim(size);
	}

	// 弹出队列中的最大元素 并返回
	public Integer delMax() {
		int max = arr[1];
		swap(arr,1,size--);
		arr[size + 1] = null;
		sink(1);
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
	
	// For test
	public static void main(String[] args) {
		MaxPQ_peak m2 = new MaxPQ_peak();
		m2.Insert(1);
		m2.Insert(2);
		m2.Insert(3);
		m2.Insert(-1);
		m2.Insert(8);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		m2.delMax();
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		m2.delMax();
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		m2.delMax();
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		m2.delMax();
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
