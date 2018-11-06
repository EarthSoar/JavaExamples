package junit4;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 *	1.��ȡEmployee����ֽ�����󣬵õ����еķ���	
 *	2.�����з������е�����������ע��ֱ�洢������@MyBeforeע��Ĵ���beforeList,����@MyAfter����afterList������@MyTest����testList
 *	3.��testList���ϵ������ڵ��� ��������ִ��beforeList�еķ�������ִ��afterList�еķ���
 */
public class JunitTest {
	public static void main(String[] args) throws Exception {
		//�õ�Employee�����еķ���
		Method[] mds = Employee.class.getDeclaredMethods();
		//����Employee�Ķ���,����ִ�з���
		Employee e = Employee.class.newInstance();
		//�ü��ϴ洢����ע���ע�ķ���
		List<Method> beforeList = new ArrayList<>();
		List<Method> afterList = new ArrayList<>();
		List<Method> testList = new ArrayList<>();
		//�����еķ������е���������
		for (Method md : mds) {
			if(md.isAnnotationPresent(MyBefore.class)){
				beforeList.add(md);
			}else if(md.isAnnotationPresent(MyAfter.class)){
				afterList.add(md);
			}else if(md.isAnnotationPresent(MyTest.class)){
				testList.add(md);
			}
		}
		//�ڶ�test�����Ĺ����У���ִ�����б�beforeע���˵ķ�����Ȼ��ִ��testע��ķ����������ִ��afterע���˵ķ���
		for (Method method : testList) {
			for (Method before : beforeList) {
				before.invoke(e);  //������û�в���
			}
			
			method.invoke(e);
			
			for (Method after : afterList) {
				after.invoke(e);
			}
		}
	}
}
