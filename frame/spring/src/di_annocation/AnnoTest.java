package di_annocation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AnnoTest {
	@Autowired
	private SomeBean someBean;
	
	@Test
	public void test() throws Exception {
		System.out.println(someBean);
	}
}
