package GenericType;

//泛型方法
//情况1):泛型类中的泛型只能适用于非静态方法,如果需要给静态方法设置泛型,此时使用泛型方法:
//情况2):泛型类中的泛型应该适用于整个类中多个方法,有时候只对某一个方法设置泛型即可.


//泛型类
class Point1<T>{
	private T x;  //相当于x 的类型是 T,
	private T y;
	public void setX(T x){
		this.x = x;
	}
	
	//注意：   getX()方法并不是泛型方法
	public T getX(){
		return x;
	}
	public void setY(T y){
		this.y = y;
	}
	public T getY(){
		return y;
	}
	//    <E> 是泛型方法的声明，必须得有,注意这里面的
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
