package map;

import java.util.*;

/**
 * @author 15626
 *	计算一个字符串中，每个字符出现的次数
 */
public class StringDemo {
	public static void main(String []args){
		String str = "qwdnoiacnopqncaoifqpo";
		char[] arr = str.toCharArray();
		//key：存储字符名称；value：存储字符出现次数;
		Map<Character,Integer> map = new TreeMap<>();
		//循环得到一个字符
		for(char ch : arr){
			//判断该字符是否在当前key中存在
			if(map.containsKey(ch)){
				//Map中的key包含该字符，此时应该取出value然后给value + 1
				map.put(ch, map.get(ch) + 1);
			}else{
				//Map中的key不包含该字符，此时，把该字符添加到key中，接着把value设置为  1
				map.put(ch, 1);
			}
		}
		//HashMap不会保证添加的先后顺序
		//TreeMap会按照自然排序或者定制排序进行排序
		//LinkedHashMap会保证元素的添加顺序
		System.out.println(map);
	}
}
