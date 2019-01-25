package create_bean.way4;

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
	 * 	方式四：实现 FactoryBean接口
	 */
	
	@Autowired
	private ApplicationContext ctx;
	
	@Test
	public void test() throws Exception {
		ABean a1 = ctx.getBean("bean",ABean.class);
		ABean a2 = ctx.getBean("bean",ABean.class);
		ABean a3 = ctx.getBean("bean",ABean.class);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
	}
}
