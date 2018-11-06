package other;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 15626
 * JavaBean和Map的相互转化
 */
public class BeanUtil {
	//把JavaBean转化为map
	public static Map<String,Object> bean2map(Object bean) throws Exception{
		Map<String,Object> map = new HashMap<>();
		//获取JavaBean的描述器
		BeanInfo b = Introspector.getBeanInfo(bean.getClass(),Object.class);
		//获取属性描述器
		PropertyDescriptor[] pds = b.getPropertyDescriptors();
		//对属性迭代
		for (PropertyDescriptor pd : pds) {
			//属性名称
			String propertyName = pd.getName();
			//属性值,用getter方法获取
			Method m = pd.getReadMethod();
			Object properValue = m.invoke(bean);//用对象执行getter方法获得属性值
			
			//把属性名-属性值 存到Map中
			map.put(propertyName, properValue);
		}
		return map;
	}
	//把Map转化为JavaBean
	public static <T> T map2bean(Map<String,Object> map,Class<T> clz) throws Exception{
		//创建一个需要转换为的类型的对象
		T obj = clz.newInstance();
		//从Map中获取和属性名称一样的值，把值设置给对象(setter方法)
		
		//得到属性的描述器
		BeanInfo b = Introspector.getBeanInfo(clz,Object.class);
		PropertyDescriptor[] pds = b.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			Method setter = pd.getWriteMethod();
			setter.invoke(obj, map.get(pd.getName()));
		}
		return obj;
	}
	public static void main(String[] args) throws Exception {
		User u = new User("小李", 19, false);
		Map<String, Object> map = new HashMap<>();
		System.out.println(map);
		map = bean2map(u);
		System.out.println(map);
		System.out.println("============");
		User obj = map2bean(map, User.class);
		System.out.println(obj);
	}
}
