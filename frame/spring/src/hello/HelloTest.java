package hello;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@SuppressWarnings("all")
public class HelloTest {
	@Test
	public void testsHello() {
		//1.从classpath路径下加载资源文件，创建资源对象
		Resource resource = new ClassPathResource("applicationContext.xml");
		//2.创建Spring容器的对象
		/**
		 * BeanFactory表示的是Spring的容器负责配置创建和管理bean
		 */
		BeanFactory factory = new XmlBeanFactory(resource);
		//3.从容器中获取指定id名称的对象
		Hello h = (Hello) factory.getBean("hello");
		h.sayHello();
	}
	//模拟Spring管理bean
	@Test
	public void test() throws Exception {
		//解析xml文档获取类的全限定名，属性名称和属性值
		Class clz = Class.forName("hello.Hello");
		Constructor con = clz.getConstructor();//得到无参数 的构造器
		con.setAccessible(true);//设置可访问 
		Object obj = con.newInstance();//创建bean的对象
		//用内省机制来获取类中的属性给属性设置值
		PropertyDescriptor[] pds = Introspector.getBeanInfo(clz).getPropertyDescriptors();//获得属性描述器
		for (PropertyDescriptor pd : pds) {
			if("name".equals(pd.getName())) {
				pd.getWriteMethod().invoke(obj, "Spring");//setter方法
			}
		}
		//调用方法
		Hello h = (Hello) obj;
		h.sayHello();
	}
	
	@Test
	/**
	 * 获取bean对象的方式
	 */
	public void test1() {
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		Hello bean = null;
		//1.按照类型去获取bean对象   (需要在配置中只配置这一种类型的实例)
		//bean = factory.getBean(Hello.class);
		//2.通过名称来获取bean对象，不安全,没有泛型
		//bean = (Hello) factory.getBean("hello");
		//3.通过名称和类型来获取(使用这个方式)
		bean = factory.getBean("hello", Hello.class);
		bean.sayHello();
	}
}
