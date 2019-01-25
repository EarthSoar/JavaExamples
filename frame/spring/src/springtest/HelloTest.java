package springtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)//让Spring容器直接运行在JVM上
@ContextConfiguration//加载资源文件
public class HelloTest {
	@Autowired // 对象注入
	private BeanFactory factory;
	@Test
	public void testHello() {
		Hello h = factory.getBean("hello", Hello.class);
		h.sayHello();
	}
}
