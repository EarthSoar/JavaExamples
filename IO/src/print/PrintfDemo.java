package print;

public class PrintfDemo {
	public static void main(String[] args){
		//java�ĸ�ʽ����ӡ��printf
		String format = "����:%s,�Ա�%s";
		Object[]data = {"С��","��"};
		System.out.printf(format, data);

		System.out.println();
		
		//�򻯰�,��C���Ժ�����
		System.out.printf("����:%s,�Ա�%s", "С��","��");
	}
}
