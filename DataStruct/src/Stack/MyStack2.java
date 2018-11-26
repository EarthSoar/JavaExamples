package Stack;

public class MyStack2<T> {
	private T a[];
	private int size;
	
	//��ʼ��ջ
	@SuppressWarnings("unchecked")
	public MyStack2(int initcap){
		 a = (T[]) new Object[initcap];
	}
	//Ĭ�ϳ�ʼ������Ϊ10
	public MyStack2(){
		this(10);
	}
	//ѹջ
	public void push(T ele){
		//��������ݲ����ˣ����������ݣ�ÿ������1��
		if(size == a.length){
			resize(a.length * 2);
		}
		a[size++] = ele;
	}
	
	//��ջ
	public T pop(){
		T ele = a[--size];
		a[size] = null;
		//ջ��Ԫ�������ķ�֮һ,��������һ��,��֤�����ʲ������ķ�֮һ
		if(size > 0 && size == a.length / 4){
			resize(a.length/2);
		}
		return ele;
	}
	public void resize(int max) {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[max];
		for(int i = 0; i < size;i++){
			temp[i] = a[i];
		}
		a = temp;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public int size(){
		return size;
	}
	public static void main(String[] args) {
		MyStack2<String> m = new MyStack2<String>(3);
		m.push("S");
		m.push("H");
		m.push("I");
		m.push("C");
		m.push("N");
		Object o = m.pop();
		System.out.println(o);
	}
}
