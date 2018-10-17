package Stack;

import Aarray.MyArrayList;

//基于数组来实现栈结构:
	//规定: 最后一个位置是栈顶.
	//索引为0的位置就是栈底.

public class MyStack extends MyArrayList {
	//压入栈
	public void  push(Object ele){
		super.add(ele);
	}
	
	//出栈
	public void pop(){
		int index = super.size() - 1;
		super.delete(index);
	}
	
	//查询栈顶元素
	public Object peek(){
		int index = super.size() - 1;
		return get(index);
	}
}
