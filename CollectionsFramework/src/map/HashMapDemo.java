package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 15626
 *	����HashMap��һЩ���õķ���
 */
public class HashMapDemo {
	public static void main(String []args){
		Map<String,Object> map = new HashMap<>();
		map.put("A", "value1");
		map.put("B", "value2");
		map.put("C", "value3");
		map.put("D", "value4");
		//ӳ���ϵ�����key��ͬ��value��ͬ������ĻḲ��ǰ���
		//map.put("D", "4");
		
		//�Ƴ�����ӳ���ϵ
		//map.clear();
		System.out.println(map);
		
		//containKey�������ж�ӳ���еİ���ָ������ӳ���ϵ���з���true
		System.out.println(map.containsKey("A"));
		Set<String> keyset = map.keySet();
		System.out.println(keyset);
		
		//�õ�map�еļ�ֵ�Եĸ���
		System.out.println(map.size());
		//��ȡmap������key��ɵļ��ϣ�key�������ظ���������Set��map����ʹ��for-each,����key��ɵ�Ser����keyʹ��
		for(String key : keyset){
			System.out.println(key + " = " + map.get(key));
		}
		//��ȡmap������value��ɵļ��ϣ�value�����ظ���������List������ʹ��for-each
		Collection<Object> values = map.values();
		for(Object value : values ){
			System.out.println(value);
		}
		
		//��ȡMap�е�Entry,��ֵ��
		Set<Map.Entry<String, Object>> entrys =  map.entrySet();
		//EntryҲ���Կ���һ����һ��Set����
		for( Map.Entry<String, Object> entry1 : entrys){
			String key = entry1.getKey();
			Object value = entry1.getValue();
			System.out.println(key + "," + value);
		}
	}
}
