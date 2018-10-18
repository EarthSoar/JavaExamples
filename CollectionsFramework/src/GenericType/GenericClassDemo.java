package GenericType;

//import java.util.LinkedList;
//��ʽ����  ������������Ű���һ�� �Զ�������ͣ����ﶨ��ΪT
class Point<T>{
	private T x;  //�൱��x �������� T,
	private T y;
	public void setX(T x){
		this.x = x;
	}
	public T getX(){
		return x;
	}
	public void setY(T y){
		this.y = y;
	}
	public T getY(){
		return y;
	}
}

public class GenericClassDemo {
	public static void main(String []args){
	/*
		LinkedList list = new LinkedList();
		list.add(1);//�����1��Integer���͵�
		Object ele = list.get(0);  //���ﷵ�ص�ֵ��Object���͵�
		Integer num = (Integer)ele;//��Ҫ��Object����ǿתΪInteger����
		System.out.println(num);
		//�洢�������͵������ڼ����У�����Ҫȡ����ʱ����Object���͵ģ���ô��ʱ��ҪǿתΪ�������
		
	*/
		
	//���󣺶���һ��Point�࣬���Դ洢String���͵ģ�Ҳ���Դ洢Integer���͵�
	//��ʱ���͵ò��÷�����ɾͱȽϺ�
		
		Point<String> p1 = new Point<String>();     //�����������õķ���ΪString��ô��ʱ��T�Ͷ��൱����String
		p1.setX("xxx");
		String x1 = p1.getX();
		System.out.println(x1);
		
		Point<Integer> p2 = new Point<Integer>();   //�����������õķ���ΪInteger��ô��ʱ��T�Ͷ��൱����Integer
		p2.setY(222);
		Integer y2 = p2.getY();
		System.out.println(y2);

	}
}
