package array_copy;

import java.lang.reflect.Array;
import java.util.Arrays;
/**
 *	Array类中提供了动态创建和访问数组的方法
 */
public class ArrayDemo {
	public static void main(String[] args) {

		int[] arr = {1,4,5};
		//修改索引为2元素为4
		Array.set(arr, 2, 4);//[1, 4, 4]
		System.out.println(Arrays.toString(arr));
		//获取索引位置为2的元素
		int a = Array.getInt(arr, 2);
		System.out.println(a);
	}
}
