package GenericType;

//���ͷ���
//���1):�������еķ���ֻ�������ڷǾ�̬����,�����Ҫ����̬�������÷���,��ʱʹ�÷��ͷ���:
//���2):�������еķ���Ӧ���������������ж������,��ʱ��ֻ��ĳһ���������÷��ͼ���.


//������
class Point1<T>{
	private T x;  //�൱��x �������� T,
	private T y;
	public void setX(T x){
		this.x = x;
	}
	
	//ע�⣺   getX()���������Ƿ��ͷ���
	public T getX(){
		return x;
	}
	public void setY(T y){
		this.y = y;
	}
	public T getY(){
		return y;
	}
	//    <E> �Ƿ��ͷ������������������,ע���������
	public <E> T getEle(T x){
		return  x;
		
	} 
}

public class GenericMethodDemo {
	public static void main(String []args){
		Point1<String> p = new Point1<String>();
		String s = p.getEle("E");
		System.out.println(s);
	}
}
