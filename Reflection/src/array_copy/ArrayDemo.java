package array_copy;

import java.lang.reflect.Array;
import java.util.Arrays;
/**
 *	Array�����ṩ�˶�̬�����ͷ�������ķ���
 */
public class ArrayDemo {
	public static void main(String[] args) {

		int[] arr = {1,4,5};
		//�޸�����Ϊ2Ԫ��Ϊ4
		Array.set(arr, 2, 4);//[1, 4, 4]
		System.out.println(Arrays.toString(arr));
		//��ȡ����λ��Ϊ2��Ԫ��
		int a = Array.getInt(arr, 2);
		System.out.println(a);
	}
}
