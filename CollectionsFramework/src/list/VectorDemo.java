package list;

import java.util.*;

public class VectorDemo {
	public static void main(String []args){
//		Vector v1 = new Vector();
//		//��
//		v1.add("AA");//11���Զ�װ��ת��Ϊ����
//		v1.add(22);
//		v1.addElement(33);//addElement��add�ײ���һ����
//		System.out.println(v1);
		
//		Vector v2 = new Vector();
//		StringBuilder sb = new StringBuilder("SSSS");
//		v2.add(sb);//�������д洢�Ķ��󣬴洢���Ƕ�������ã������Ǵ洢��ֵ
//		System.out.println(v2);//SSSS
//		sb.append(222);
//		System.out.println(v2);//SSSS222
		
		//v2.addAll(v1);         //addAll�Ѽ���v1�е�Ԫ����������v2��
		//System.out.println(v2);  //[SSSS222, 11, 22, 33]
//		v2.add(v1);              //v1Ҳ��Object���͵�,��ô�Ͱ�v1�����������v2������
//		System.out.println(v2);  //[SSSS222, [11, 22, 33]]
		
		
		//ɾ
//		v1.remove(2);       //ɾ��ָ��������ֵ
//		System.out.println(v1);
//		
//		v1.remove("AA");   //ɾ��ָ��Ԫ�صĵ�һ��ƥ����
//		System.out.println(v1);
		
		//��
		Vector<String> v3 = new Vector<String>();
		v3.add("aaa");
		v3.add("bbb");
		v3.add("ccc");
		v3.add("ddd");
		System.out.println(v3);	//[aaa, bbb, ccc, ddd]
		v3.set(0, "mmm");    //�޸�ָ��������ֵ�����⻹�������޸ĵ�ֵ
	   //	Object o = v3.set(1, "111");   //o��ֵΪbbb
		System.out.println(v3); //[mmm, bbb, ccc, ddd]
	
		//��
		System.out.println(v3.size()); //4
		System.out.println(v3.get(2)); //c
	}
}
