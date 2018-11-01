package array_copy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *	д��System���е�arraycopy����  arraycopy(Object src,int srcpos,Object dest,int destpos,int length);
 */
public class ArraycopyDemo {
	public static void main(String[] args) {
		int[] src = new int[]{1,3,6,5,6,7};
		int[] dest = new int[6];
		System.out.println(Arrays.toString(dest));//[0, 0, 0, 0, 0, 0]
		arraycopy(src,2,dest,2,4);
		System.out.println(Arrays.toString(dest));//[0, 0, 6, 5, 6, 7]
	}
	public static void arraycopy(Object src,int srcpos,Object dest,int destpos,int length){
		if(src == null || dest == null){
			throw new NullPointerException("Դ�������Ŀ�����鶼����Ϊ��");
		}
		if(!src.getClass().isArray() || !dest.getClass().isArray()){
			throw new ArrayStoreException("���������");
		}
		if(src.getClass().getComponentType() != dest.getClass().getComponentType()){
			throw new ArrayStoreException("����������ͱ�����ͬ");
		}
		if(srcpos < 0 || destpos < 0 || length < 0 || srcpos + length > Array.getLength(src) || 
				destpos + length > Array.getLength(dest)){
			throw new IndexOutOfBoundsException("����Խ��");
		}
		
		//��ʼ����
		for(int index = srcpos; index < srcpos + length; index++,destpos++){
			//�õ�Դ�����Ԫ��
			Object value = Array.get(src, index);
			//�ѵõ���Ԫ�����õ�Ŀ��������
			Array.set(dest, destpos, value);
		}
	}
}
