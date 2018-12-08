package sort;

import java.util.Arrays;

public class QuickSort {
	public static void quickSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		quickSort(arr,0,arr.length - 1);
	}
	public static void quickSort(int[] arr,int L, int r) {
		if(L < r) {
			//产生L-r上的随机数,  把这个索引的看做目标数换到数组的最后
			swap(arr,L + (int)(Math.random()*(r - L + 1)),r);
			int p[] = partition(arr, L, r);
			quickSort(arr, L, p[0] - 1);
			quickSort(arr, p[1] + 1, r);
		}
	}
	public static int[] partition(int[] arr,int L, int r) {
		int less = L - 1;//less指向数组的前一个位置   L~less是小于区域
		int more = r;	//more指向的是数组的最后一个位置,r为目标数,  more - 1 ~ r  是大于区域
		while(L < more) {
			if(arr[L] > arr[r]) {
				swap(arr, --more, L);
			}else if(arr[L] < arr[r]) {
				swap(arr, ++less, L++);
			}else {
				L++;
			}
		}
		swap(arr,more,r);	//开始把最后一个元素当做目标忽略掉了这个元素,现在将这个元素归位
		return new int[]{less + 1, more};
	}
	public static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
	
	
	
	/**
	 * 设置对数器,用来检验结果正确性
	 */
	// 1.先有一个绝对正确的方法, 一般是一个复杂度不高但是正确的方法
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// 2.实现一个随机样本产生器
	/**
	 * @param maxSize	随机数组的最大长度,  例如传入10,产生[0,11)的随机数,对于int来说就是1-10
	 * @param maxValue	随机数组中元素的随机值的最大值
	 * @return			返回一个随机长度  并且元素也是随机的一个数组
	 */
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int arr[] = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
		}
		return arr;
	}
	//3.实现一个比对方法
	public static boolean isEqual(int arr1[],int arr2[]) {
		if(arr1 == null && arr2 != null || arr1 != null && arr2 ==null) {
			return false;
		}
		if(arr1 == null && arr2 == null) {
			return true;
		}
		if(arr1.length != arr2.length) {
			return false;
		}
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	//比较很多次两个方法产生的结果 查看是否相同相同
	public static void main(String[] args) {
		int testTime = 10000; //测试次数
		int maxSize = 30;//数组的最大尺寸
		int maxValue = 100;//数组中元素的最大值
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int arr1[] = generateRandomArray(maxSize, maxValue);//产生随机数组
			int arr2[] = arrayCopy(arr1);//拷贝数组,让这两个数组结构完全相同
			quickSort(arr1);  //需要测试的方法
			comparator(arr2);  //绝对正确的方法
			if(!isEqual(arr1, arr2)) {
				succeed = false;
				System.out.println(Arrays.toString(arr1));
				System.out.println(Arrays.toString(arr2));
				break;	//判断出不相同就调出循环
			}
		}
		System.out.println(succeed ? "Succeed!" : "Error!");
		
		int [] arr = generateRandomArray(maxSize, maxValue);
		System.out.println(Arrays.toString(arr));
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}	
	//拷贝数组
	public static int[] arrayCopy(int[] arr) {
		if(arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}
}
