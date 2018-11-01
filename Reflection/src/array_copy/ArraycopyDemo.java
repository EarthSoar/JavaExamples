package array_copy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *	写出System类中的arraycopy方法  arraycopy(Object src,int srcpos,Object dest,int destpos,int length);
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
			throw new NullPointerException("源数组或者目标数组都不能为空");
		}
		if(!src.getClass().isArray() || !dest.getClass().isArray()){
			throw new ArrayStoreException("非数组对象");
		}
		if(src.getClass().getComponentType() != dest.getClass().getComponentType()){
			throw new ArrayStoreException("数组对象类型必须相同");
		}
		if(srcpos < 0 || destpos < 0 || length < 0 || srcpos + length > Array.getLength(src) || 
				destpos + length > Array.getLength(dest)){
			throw new IndexOutOfBoundsException("索引越界");
		}
		
		//开始拷贝
		for(int index = srcpos; index < srcpos + length; index++,destpos++){
			//得到源数组的元素
			Object value = Array.get(src, index);
			//把得到的元素设置到目标数组中
			Array.set(dest, destpos, value);
		}
	}
}
