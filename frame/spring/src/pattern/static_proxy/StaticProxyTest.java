package pattern.static_proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pattern.damain.Employee;
import pattern.service.IEmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class StaticProxyTest {
	
	@Autowired
	private IEmployeeService proxy;//代理
	
	@Test
	public void testSave() throws Exception {
		proxy.save(new Employee());
	}
	
	@Test
	public void testUpdate() throws Exception {
		proxy.update(new Employee());
	}
}
