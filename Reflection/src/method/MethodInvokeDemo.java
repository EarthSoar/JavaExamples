package method;

import java.lang.reflect.Method;

/**
 * @author 15626
 *	ʹ�÷�����÷���
 *	 Object invoke(Object obj, Object... args) 
          �Դ���ָ��������ָ����������ɴ� Method �����ʾ�ĵײ㷽���� 
          
    ����static��������̬���������౾����ʱ��invoke�����Ĳ�������incoike(null,Object... args),Ҳ���ǲ���Ҫ����
 */
class People{
	public void doWork(){
		System.out.println("�����޲�����doWork");
	}
	public String doWork(String name){
		System.out.println("���Ǵ�������doWork");
		return name;
	}
	@SuppressWarnings("unused")
	private void eat(){
		System.out.println("����eat����");
	}
}
public class MethodInvokeDemo {
	public static void main(String[] args) throws Exception {
		//��ȡ����ֽ������
		Class<People> clz = People.class;
		Method m =clz.getMethod("doWork");
		m.invoke(clz.newInstance());
		
		System.out.println("============");
		
		m = clz.getMethod("doWork", String.class);
		Object o = m.invoke(clz.newInstance(), "xxx");
		System.out.println(o);
		
		m = clz.getDeclaredMethod("eat");
		m.setAccessible(true);//���÷�����ִ��
		People p = clz.newInstance();
		m.invoke(p);
	}
}
