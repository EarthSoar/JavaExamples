package sort;

import java.util.Arrays;

public class MergeSort {
	public static void mergeSort(int arr[]) {
		if(arr == null || arr.length < 2) {
			return;
		}
		mergeSort(arr,0,arr.length - 1);
	}
	public static void mergeSort(int[] arr,int L, int r) {
		if(L == r) {
			return;
		}
		int mid = L + (r - L) / 2;
		mergeSort(arr, L, mid);
		mergeSort(arr, mid + 1, r);
		merge(arr,L,mid,r);
	}
	public static void merge(int[] arr,int L, int mid, int r) {
		int[] help = new int[r - L + 1];
		int i = 0;
		int p1 = L;
		int p2 = mid + 1;
		while(p1 <= mid && p2 <= r) {
			if(arr[p1] <= arr[p2]) {
				help[i++] = arr[p1++];
			} else {
				help[i++] = arr[p2++];
			}
			//help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while(p1 <= mid) {
			help[i++] = arr[p1++];
		}
		while(p2 <= r) {
			help[i++] = arr[p2++];
		}
		
		for (i = 0; i < help.length; i++) {
			arr[L + i] = help[i];
		}
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
/*	public static boolean isEqual(int arr1[],int arr2[]) {
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
	}*/
	//比较很多次两个方法产生的结果 查看是否相同相同
	public static void main(String[] args) {
		int testTime = 10000; //测试次数
		int maxSize = 30;//数组的最大尺寸
		int maxValue = 100;//数组中元素的最大值
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int arr1[] = generateRandomArray(maxSize, maxValue);//产生随机数组
			int arr2[] = Arrays.copyOf(arr1, arr1.length);//拷贝数组,让这两个数组结构完全相同
			mergeSort(arr1);  //需要测试的方法
			comparator(arr2);  //绝对正确的方法
			if(!Arrays.equals(arr1, arr2)) {
				succeed = false;
				break;	//判断出不相同就调出循环
			}
		}
		System.out.println(succeed ? "Succeed!" : "Error!");
		
		int [] arr = generateRandomArray(maxSize, maxValue);
		System.out.println(Arrays.toString(arr));
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}	
	//拷贝数组
/*	public static int[] arrayCopy(int[] arr) {
		if(arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}*/
}
