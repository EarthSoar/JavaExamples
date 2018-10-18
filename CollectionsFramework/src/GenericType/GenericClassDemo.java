package GenericType;

//import java.util.LinkedList;
//格式就是  类名后面间括号包含一个 自定义的类型，这里定义为T
class Point<T>{
	private T x;  //相当于x 的类型是 T,
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
		list.add(1);//这里的1是Integer类型的
		Object ele = list.get(0);  //这里返回的值是Object类型的
		Integer num = (Integer)ele;//需要把Object类型强转为Integer类型
		System.out.println(num);
		//存储任意类型的数据在集合中，当需要取出的时候都是Object类型的，那么此时需要强转为具体对象
		
	*/
		
	//需求：定义一个Point类，可以存储String类型的，也可以存储Integer类型的
	//此时，就得采用泛型完成就比较好
		
		Point<String> p1 = new Point<String>();     //创建对象所用的泛型为String那么此时的T就都相当于是String
		p1.setX("xxx");
		String x1 = p1.getX();
		System.out.println(x1);
		
		Point<Integer> p2 = new Point<Integer>();   //创建对象所用的泛型为Integer那么此时的T就都相当于是Integer
		p2.setY(222);
		Integer y2 = p2.getY();
		System.out.println(y2);

	}
}
