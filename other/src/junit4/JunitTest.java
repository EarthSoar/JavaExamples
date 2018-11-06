package junit4;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 *	1.获取Employee类的字节码对象，得到所有的方法	
 *	2.对所有方法进行迭代，将三类注解分别存储，把有@MyBefore注解的存在beforeList,带有@MyAfter存在afterList，带有@MyTest存在testList
 *	3.对testList集合迭代，在迭代 过程中先执行beforeList中的方法，在执行afterList中的方法
 */
public class JunitTest {
	public static void main(String[] args) throws Exception {
		//得到Employee中所有的方法
		Method[] mds = Employee.class.getDeclaredMethods();
		//创建Employee的对象,用来执行方法
		Employee e = Employee.class.newInstance();
		//用集合存储三类注解标注的方法
		List<Method> beforeList = new ArrayList<>();
		List<Method> afterList = new ArrayList<>();
		List<Method> testList = new ArrayList<>();
		//对所有的方法进行迭代，分类
		for (Method md : mds) {
			if(md.isAnnotationPresent(MyBefore.class)){
				beforeList.add(md);
			}else if(md.isAnnotationPresent(MyAfter.class)){
				afterList.add(md);
			}else if(md.isAnnotationPresent(MyTest.class)){
				testList.add(md);
			}
		}
		//在对test迭代的过程中，先执行所有被before注解了的方法，然后执行test注解的方法，最后再执行after注解了的方法
		for (Method method : testList) {
			for (Method before : beforeList) {
				before.invoke(e);  //方法都没有参数
			}
			
			method.invoke(e);
			
			for (Method after : afterList) {
				after.invoke(e);
			}
		}
	}
}
