package pattern.cglib;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pattern.damain.Employee;
import pattern.service.IEmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class jdkProxyTest {
	
	@Autowired
	private TransactionManagerCallback callback;//代理
	
	@Test
	public void testSave() throws Exception {
		IEmployeeService service = (IEmployeeService) callback.getProxy();
		service.save(new Employee());
	}
	
	@Test
	public void testUpdate() throws Exception {
		IEmployeeService service = (IEmployeeService) callback.getProxy();
		//System.out.println(service.getClass());//class pattern.service.impl.EmployeeServiceImpl$$EnhancerByCGLIB$$1d57fdf4
		service.update(new Employee());
	}
	
}
