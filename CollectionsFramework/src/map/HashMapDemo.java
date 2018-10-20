package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 15626
 *	操作HashMap的一些常用的方法
 */
public class HashMapDemo {
	public static void main(String []args){
		Map<String,Object> map = new HashMap<>();
		map.put("A", "value1");
		map.put("B", "value2");
		map.put("C", "value3");
		map.put("D", "value4");
		//映射关系，如果key相同，value不同，后面的会覆盖前面的
		//map.put("D", "4");
		
		//移除所有映射关系
		//map.clear();
		System.out.println(map);
		
		//containKey方法，判断映射中的包含指定键的映射关系，有返回true
		System.out.println(map.containsKey("A"));
		Set<String> keyset = map.keySet();
		System.out.println(keyset);
		
		//得到map中的键值对的个数
		System.out.println(map.size());
		//获取map中所有key组成的集合，key不可以重复，类似于Set，map不能使用for-each,但是key组成的Ser集合key使用
		for(String key : keyset){
			System.out.println(key + " = " + map.get(key));
		}
		//获取map中所有value组成的集合，value可以重复，类似于List，可以使用for-each
		Collection<Object> values = map.values();
		for(Object value : values ){
			System.out.println(value);
		}
		
		//获取Map中的Entry,键值段
		Set<Map.Entry<String, Object>> entrys =  map.entrySet();
		//Entry也可以看做一个是一个Set集合
		for( Map.Entry<String, Object> entry1 : entrys){
			String key = entry1.getKey();
			Object value = entry1.getValue();
			System.out.println(key + "," + value);
		}
	}
}
