package create_bean.way1;

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
	 * 创建Bean的四种方式
	 */
	// 方式一：构造器实例化 (无参数)
	@Autowired
	private ApplicationContext ctx;

	@Test
	public void test() throws Exception {
		ABean h = ctx.getBean("bean", ABean.class);
		System.out.println(h);
	}
}
