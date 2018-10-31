package class_instance;

/**
 * 	���������л����������ͺ�������������(����)
 *	
 *	������������û����ĸ��Ҳû�ж�����˲���ʹ�÷�ʽ���ͷ�ʽ��
 * 	Class clz = ��������.class	
 *	����һ��void���оŴ�����classʵ��
 *	
 */
public class DataTypeInstanceDemo {
	public static void main(String[] args) {
		//������������
		System.out.println(int.class);
		System.out.println(double.class);
		System.out.println(void.class);
		
		
		/**
		 * �ڻ������͵İ�װ�����ж�����һ��TYPE��һ�����������ظð�װ���Ͷ�Ӧ�������͵��ֽ������
		 * static Class<Integer> TYPE  
		 */
		System.out.println("==============");
		
		Class<Integer> clz = Integer.TYPE;
		System.out.println(clz);
		System.out.println(clz == int.class);//true  ע��Integer���Լ����ֽ�����󣬺�int�϶�����ͬ
		
		System.out.println("==============");
		
		//����
		/**
		 * ���о�����ͬά���ĺ���ͬ�������͵�������JVM��ֻ��һ���ֽ�����󣬺�������Ԫ��û���κι�ϵ
		 */
		int[] arr = {1,1,2,5};  //arr���������
		int[] arr2 = {1,1,2,3,4,5};  //arr2���������
		//��ʽ��
		System.out.println(arr.getClass());//class [I
		System.out.println(arr2.getClass());//class [I
		//��ʽһ
		Class<int[]> clz3 = int[].class;
		System.out.println(clz3);
		System.out.println(clz3 == arr2.getClass());//true
		
	}
}
