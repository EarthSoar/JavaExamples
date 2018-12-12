package example;

import java.util.Arrays;

/**	小和问题
 * @author Willing
 *	在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和。
 *	例子：
		[1,3,4,2,5]
		1左边比1小的数，没有；
		3左边比3小的数，1；
		4左边比4小的数，1、3；
		2左边比2小的数，1；
		5左边比5小的数，1、3、4、2；
		所以小和为1+1+3+1+1+3+4+2=16
 */
public class SmallSum {
	public static int smallSum(int arr[]) {
		if(arr == null || arr.length < 2) {
			return 0;
		}
		return merge(arr,0,arr.length - 1);
	}
	public static int merge(int[] arr,int L, int r) {
		if(L == r) {
			return 0;
		}
		int mid = L + (r - L) / 2;
		return merge(arr, L, mid) + 
		merge(arr, mid + 1, r) +
		merge(arr,L,mid,r);
	}
	public static int merge(int[] arr,int L, int mid, int r) {
		int[] help = new int[r - L + 1];
		int i = 0;
		int p1 = L;
		int p2 = mid + 1;
		int res = 0;
		while(p1 <= mid && p2 <= r) {
			if(arr[p1] <= arr[p2]) {
				//在归并排序进行左右两个数组进行合并排序的时候进行计算。如果左边数组元素arr[p1]，小于右边数组元素arr[p2]，
				//从右边数组右指针P2到右边数组最后r就有(r-p2+1)个arr[p1]
				res += (r - p2 + 1) * arr[p1];//在归并中多了一行操作
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
		return res;
	}
	public static void main(String[] args) {
		int[] arr = { 5, 3, 6, 9, 2 };
		System.out.println(Arrays.toString(arr));
		int res = smallSum(arr);
		System.out.println(res);
	}
}
