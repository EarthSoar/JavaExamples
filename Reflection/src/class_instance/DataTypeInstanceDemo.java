package class_instance;

/**
 * 	数据类型有基本数据类型和引用数据类型(数组)
 *	
 *	基本数据类型没有类的概念，也没有对象，因此不能使用方式二和方式三
 * 	Class clz = 数据类型.class	
 *	加上一个void，有九大内置class实例
 *	
 */
public class DataTypeInstanceDemo {
	public static void main(String[] args) {
		//基本数据类型
		System.out.println(int.class);
		System.out.println(double.class);
		System.out.println(void.class);
		
		
		/**
		 * 在基本类型的包装类型中都存在一个TYPE的一个常量，返回该包装类型对应基本类型的字节码对象
		 * static Class<Integer> TYPE  
		 */
		System.out.println("==============");
		
		Class<Integer> clz = Integer.TYPE;
		System.out.println(clz);
		System.out.println(clz == int.class);//true  注意Integer有自己的字节码对象，和int肯定不相同
		
		System.out.println("==============");
		
		//数组
		/**
		 * 所有具有相同维数的和相同数据类型的数组在JVM中只有一个字节码对象，和数组中元素没有任何关系
		 */
		int[] arr = {1,1,2,5};  //arr是数组对象
		int[] arr2 = {1,1,2,3,4,5};  //arr2是数组对象
		//方式二
		System.out.println(arr.getClass());//class [I
		System.out.println(arr2.getClass());//class [I
		//方式一
		Class<int[]> clz3 = int[].class;
		System.out.println(clz3);
		System.out.println(clz3 == arr2.getClass());//true
		
	}
}
