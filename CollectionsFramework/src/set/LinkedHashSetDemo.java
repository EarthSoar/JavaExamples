package set;

import java.util.*;

/**
 * @author 15626
 *  LinkedHashSet,�����ֿ��Կ������ײ���õ�������͹�ϣ���㷨
 *  ����֤Ԫ�صĲ���˳��HashSet����֤Ԫ�ز��ظ�
 *  ����̳���LinkedHashList����Ϊ����Linked,���Ч����Խϵ���
 */
public class LinkedHashSetDemo{
	public static void main(String []args){
		Set<String> set = new LinkedHashSet<String>();
		set.add("111");
		set.add("abc");
		set.add("abc");
		set.add("AAA");
		set.add("ff");
		System.out.println(set);// [111, abc, AAA, ff]
	}
}
