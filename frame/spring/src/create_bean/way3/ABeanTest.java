package create_bean.way3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ABeanTest {
	@Test
	public void testOld() throws Exception {
		ABean bean = new ABeanFactory().getBean();
		System.out.println(bean);
	}
}

