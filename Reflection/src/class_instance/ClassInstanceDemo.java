package class_instance;

/**
 *	��ȡһ��Class����
 *	
 *	��ʽһ��ʹ��class���ԣ����е��������Ͷ����У�
 *	��ʽ����ʹ�ö����getClass()    �÷�����Object���еģ�˵�����������͵Ķ��󶼿ɵ���
 *	��ʽ����Class���еľ�̬����forName(String className),className�����Ȩ�޶�����
 */
public class ClassInstanceDemo {
	public static void main(String[] args) throws Exception {
		//��ʽһ
		Class<java.util.Date> clz1 = java.util.Date.class;
		//��ʽ��
		java.util.Date data = new java.util.Date();
		Class<?> clz2 = data.getClass();
		//��ʽ��
		Class<?> clz3 = Class.forName("java.util.Date");
		
		System.out.println(clz1);//Class���и�����toString����,����ֱ�ӿ���д���������
		System.out.println(clz2);//Class���и�����toString����,����ֱ�ӿ���д���������
		System.out.println(clz3);//Class���и�����toString����,����ֱ�ӿ���д���������
		
		System.out.println(clz1 == clz2);//��ͬһ�����У�JVM��ֻ����һ���ֽ������
	}
}
