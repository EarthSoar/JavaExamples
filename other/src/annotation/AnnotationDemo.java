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
	 * jdk�Դ���ע��
	 */
	@Override
	public String toString() {
		return super.toString();
	}
	@SuppressWarnings("all")//���Ʊ������ľ���
	Set set = new HashSet();
	@SuppressWarnings("rawtypes")
	Map map = new HashMap();
	
	
}
//������һ����ΪTestAnnotation�ı�ǩ

/**
 *	���������ڣ��ֱ�ΪRESOURCE(Դ����׶�),CLASS(�ֽ���׶�),RUNTIME(����ʱ�ڣ�Ҳ������JVM��),
 *	��@Retention(RetetionPolicy.����ֵ)
 */

/**
 *	Ԫע�⣺ע���ע��
 *	@Retention(RetetionPolicy.����ֵ)//RESOURCE,CLASS,RUNTIME
 *	@Target({ElementsType.����ֵ})//TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE
 *	@Inherited  //����̳������ǩ
 *	@Documented//�����������ܹ���ע���е�Ԫ�ذ����� Javadoc API��ȥ
 *	@Repeatable //���ظ���|java8
 */
@Inherited  //����̳������ǩ
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})//��������Ԫ�ص�Ŀ������
@Retention(RetentionPolicy.RUNTIME)   //�������ڵ�����ʱ��
@interface TestAnnotation{
	//��ע���ж�������
	//��ע���ж�������ʱ�������ͱ����� 8 �ֻ�������������� �ࡢ�ӿڡ�ע�⼰���ǵ����顣������Integer..
	//ע�������Կ�����Ĭ��ֵ��Ĭ��ֵ��Ҫ�� default �ؼ�ֵָ��
	
	int id() default 0;
	String msg() default "hello";
}
@TestAnnotation(id = 3,msg = "aa")
class Test1{
	
}

//��ע����ֻ��һ��value����ʱ������ǩ��ʱ�����ʡ��value��
//��ע����û������ʱ�����Ŷ�����ʡ�ԣ�overrideע�⣩
@interface Test1Annotation{
	int[] value();
}
@Test1Annotation({1,2})
class Test2{
	
}

