package annotation;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class AnnotationDemo {
	/**
	 * jdk自带的注解
	 */
	@Override
	public String toString() {
		return super.toString();
	}
	@SuppressWarnings("all")//抑制编译器的警告
	Set set = new HashSet();
	@SuppressWarnings("rawtypes")
	Map map = new HashMap();
	
	
}
//创建了一个名为TestAnnotation的标签

/**
 *	有三个周期，分别为RESOURCE(源代码阶段),CLASS(字节码阶段),RUNTIME(运行时期，也就是在JVM中),
 *	用@Retention(RetetionPolicy.常亮值)
 */

/**
 *	元注解：注解的注解
 *	@Retention(RetetionPolicy.常亮值)//RESOURCE,CLASS,RUNTIME
 *	@Target({ElementsType.常亮值})//TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE
 *	@Inherited  //子类继承这个标签
 *	@Documented//它的作用是能够将注解中的元素包含到 Javadoc API中去
 *	@Repeatable //可重复的|java8
 */
@Inherited  //子类继承这个标签
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})//被贴程序元素的目标类型
@Retention(RetentionPolicy.RUNTIME)   //保留周期到运行时期
@interface TestAnnotation{
	//在注解中定义属性
	//在注解中定义属性时它的类型必须是 8 种基本数据类型外加 类、接口、注解及它们的数组。不能是Integer..
	//注解中属性可以有默认值，默认值需要用 default 关键值指定
	
	int id() default 0;
	String msg() default "hello";
}
@TestAnnotation(id = 3,msg = "aa")
class Test1{
	
}

//当注解中只有一个value属性时候，贴标签的时候可以省略value。
//当注解中没有属性时，括号都可以省略（override注解）
@interface Test1Annotation{
	int[] value();
}
@Test1Annotation({1,2})
class Test2{
	
}

