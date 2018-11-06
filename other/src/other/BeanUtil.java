package other;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 15626
 * JavaBean��Map���໥ת��
 */
public class BeanUtil {
	//��JavaBeanת��Ϊmap
	public static Map<String,Object> bean2map(Object bean) throws Exception{
		Map<String,Object> map = new HashMap<>();
		//��ȡJavaBean��������
		BeanInfo b = Introspector.getBeanInfo(bean.getClass(),Object.class);
		//��ȡ����������
		PropertyDescriptor[] pds = b.getPropertyDescriptors();
		//�����Ե���
		for (PropertyDescriptor pd : pds) {
			//��������
			String propertyName = pd.getName();
			//����ֵ,��getter������ȡ
			Method m = pd.getReadMethod();
			Object properValue = m.invoke(bean);//�ö���ִ��getter�����������ֵ
			
			//��������-����ֵ �浽Map��
			map.put(propertyName, properValue);
		}
		return map;
	}
	//��Mapת��ΪJavaBean
	public static <T> T map2bean(Map<String,Object> map,Class<T> clz) throws Exception{
		//����һ����Ҫת��Ϊ�����͵Ķ���
		T obj = clz.newInstance();
		//��Map�л�ȡ����������һ����ֵ����ֵ���ø�����(setter����)
		
		//�õ����Ե�������
		BeanInfo b = Introspector.getBeanInfo(clz,Object.class);
		PropertyDescriptor[] pds = b.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			Method setter = pd.getWriteMethod();
			setter.invoke(obj, map.get(pd.getName()));
		}
		return obj;
	}
	public static void main(String[] args) throws Exception {
		User u = new User("С��", 19, false);
		Map<String, Object> map = new HashMap<>();
		System.out.println(map);
		map = bean2map(u);
		System.out.println(map);
		System.out.println("============");
		User obj = map2bean(map, User.class);
		System.out.println(obj);
	}
}
