package map;

import java.util.*;

/**
 * @author 15626
 *	����һ���ַ����У�ÿ���ַ����ֵĴ���
 */
public class StringDemo {
	public static void main(String []args){
		String str = "qwdnoiacnopqncaoifqpo";
		char[] arr = str.toCharArray();
		//key���洢�ַ����ƣ�value���洢�ַ����ִ���;
		Map<Character,Integer> map = new TreeMap<>();
		//ѭ���õ�һ���ַ�
		for(char ch : arr){
			//�жϸ��ַ��Ƿ��ڵ�ǰkey�д���
			if(map.containsKey(ch)){
				//Map�е�key�������ַ�����ʱӦ��ȡ��valueȻ���value + 1
				map.put(ch, map.get(ch) + 1);
			}else{
				//Map�е�key���������ַ�����ʱ���Ѹ��ַ���ӵ�key�У����Ű�value����Ϊ  1
				map.put(ch, 1);
			}
		}
		//HashMap���ᱣ֤��ӵ��Ⱥ�˳��
		//TreeMap�ᰴ����Ȼ������߶��������������
		//LinkedHashMap�ᱣ֤Ԫ�ص����˳��
		System.out.println(map);
	}
}
