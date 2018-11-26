package Stack;

public class MyStack2<T> {
	private T a[];
	private int size;
	
	//初始化栈
	@SuppressWarnings("unchecked")
	public MyStack2(int initcap){
		 a = (T[]) new Object[initcap];
	}
	//默认初始化容量为10
	public MyStack2(){
		this(10);
	}
	//压栈
	public void push(T ele){
		//如果数组容不下了，对数组扩容，每次扩大1倍
		if(size == a.length){
			resize(a.length * 2);
		}
		a[size++] = ele;
	}
	
	//出栈
	public T pop(){
		T ele = a[--size];
		a[size] = null;
		//栈中元素少于四分之一,容量减少一半,保证利用率不低于四分之一
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
