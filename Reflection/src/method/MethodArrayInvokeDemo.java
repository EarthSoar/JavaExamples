package method;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *	ʹ�÷����������ɱ�������ɱ���������Ͼ�������
 *	Method����.invoke(������������,new Object[]{���е�ʵ��});
 */
class Test{
	//�������Ϳɱ����
	public void doWork(int...arr){
		System.out.println("doWork����������," + Arrays.toString(arr));
	}
	//�������Ϳɱ����
	public static void doWork2(String...arr){
		System.out.println("doWork2����������," + Arrays.toString(arr));
	}
}
public class MethodArrayInvokeDemo {
	public static void main(String[] args) throws Exception {
		//��ȡ����ֽ������
		Class<Test> clz = Test.class;
	
		//�������͵�������ã��ڶ���ʵ�δ��Ŀ������½�һ��int���͵����顣Ҳ������Object������а�װ
		Method m = clz.getMethod("doWork", int[].class);
	//	m.invoke(clz.newInstance(), new int[]{1,2,3});
		m.invoke(clz.newInstance(), new Object[]{new int[]{1,2,3,3}});
		
		//�������͵ķ������ã��ڶ���ʵ��ֻ�ܷ���Objec���͵�������
		m = clz.getMethod("doWork2", String[].class);
		m = clz.getMethod("doWork2", String[].class);
		//m.invoke(clz.newInstance(), new String[]{"A","B"});//�����д��
		m.invoke(clz.newInstance(), new Object[]{new String[]{"A","B"}});
		
	}
}
