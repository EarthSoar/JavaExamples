package Aarray;

import java.util.Arrays;

public class MyArrayList {
	//存储任意类型元素
		private  Object[] elements = null;
		//数组中元素的个数
		private  int size = 0;
		//初始化默认容量
		private static final int DEFAULT_INIT_CAPACITY = 10;
		public MyArrayList(){  //无参构造器,则自动调用下面的有参数的构造器;
			this(DEFAULT_INIT_CAPACITY);
		}
		//构造器用来初始化数组
		public MyArrayList(int initialcapcity) {
			if(initialcapcity < 0){
				throw new IllegalArgumentException("容量不能为负数");
			}	
			elements = new Object[initialcapcity];
		}
		
		//增加新元素
		public  void add(Object eleNum){
			
			if(size == elements.length){   //存满了，数组自动扩容,扩容机制为2倍
				Object[] temp = Arrays.copyOf(elements,elements.length*2);
				elements = temp;
			}
				
			elements[size] = eleNum;
			size++;
		}
		
		//查询制定索引对应的值
		public  Object get(int index){
			if(index < 0 || index >= size){//索引越界了
				throw new IllegalArgumentException("索引越界");
			}
			return elements[index];
		}
		
		//替换指定元素的索引值
		public  void set(int index,Object neweleNum) {
			if(index < 0 || index >= size){//索引越界了
				throw new IllegalArgumentException("索引越界");
			}
			elements[index] = neweleNum;
		}
		//删除指定索引的值
		public  void delete(int index){
			if(index < 0 || index >= size){//索引越界了
				throw new IllegalArgumentException("索引越界");
			}
			for(int i = index;i < size -1 ;i++){   //size - 1  防止数组越界，最后把索引size-1置为null
				elements[index] = elements[index + 1];//把index+1的移动到index
			}
			//把index 置为null 
			elements[size - 1] = null ;
			//数组长度 减1
			size--;
		}
		
		//打印数组
		public String toString(){
			if(elements == null){
				//System.out.println("null");
				return "null";//结束方法
			}
			if(size == 0){
				//System.out.println("[]");
				return "[]";
			}
			StringBuilder sb = new StringBuilder(size*2 + 1);
			sb.append("[");
			for(int index = 0;index < size ;index++){
				sb.append(elements[index]);
				if(index != size - 1){//若数组不是最后一个元素
					sb.append(",");
				}else{
					sb.append("]");
				}
			}
			//System.out.println(sb.toString());
			return sb.toString();
		}
		
		//数组元素的个数
		public int size() {
			return size;
		}
		
		//清空
		public  void clear(){
			//this.elements = new Object[DEFAULT_INIT_CAPACITY];
			for(int i = 0;i < size; i++)
			{
				elements[i] = null;
			}
			size = 0;
		}
		
		//判断数组是否为空
		public boolean isEmplty(){
			return size == 0;
		}

}
