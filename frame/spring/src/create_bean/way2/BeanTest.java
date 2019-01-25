package create_bean.way2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class BeanTest {
	/**
	 * 	方式二：静态工厂方法实例化
	 */
	
	@Test
	public void testOld() throws Exception {
		ABean a = ABeanFactory.getBean();
		System.out.println(a);
	}
	
	@Autowired
	private ApplicationContext ctx;
	
	@Test
	public void test() throws Exception {
		ABean a = ctx.getBean("bean",ABean.class);
		System.out.println(a);
	}
}
