package ioc;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@SuppressWarnings("all")
public class HelloTest {
	/**
	 * BeanFactory 等到需要得到bean对象的时候才会创建bean对象
	 */
	@Test
	public void testBeanFactory() throws Exception {
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		Hello h = factory.getBean("hello", Hello.class);
		h.sayHello();
	}

	/**
	 * ApplicationContext 是在加载的时候就创建出所有的bean对象 ,ApplicationContext是Beanfactory的子类 功能更加强大
	 */
	@Test
	public void testApplicationContext() throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Hello h = ctx.getBean("hello",Hello.class);
		h.sayHello();
	}
}
