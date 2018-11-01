package api;

import java.lang.reflect.Modifier;

/**
 *	Class���API
 *
 */
public class Demo {
	public static void main(String[] args){
		String name = Demo.class.getName();//getName()���ظ����Ȩ�޵�Ȩ�޵�����
		System.out.println(name);
		
		String packagename = Demo.class.getPackage().getName();//getPackage()���ظ������ڵİ���
		System.out.println(packagename);
		
		int mod = Demo.class.getModifiers();//���ظ�������η�
		String type = Modifier.toString(mod);
		System.out.println(type);
		
		String supername = Demo.class.getSuperclass().getName();//���ظ��������
		System.out.println(supername);
		
		Object arr = new int[]{1,2,2};//�жϸ��ֽ�������Ƿ��������࣬Ҳ����ʵ�������ǲ�������
		System.out.println(arr.getClass().isArray());
	}
}
