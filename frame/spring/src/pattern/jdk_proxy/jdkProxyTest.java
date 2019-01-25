package pattern.jdk_proxy;

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
	private TransactionManagerHandler handler;//代理
	
	@Test
	public void testSave() throws Exception {
		IEmployeeService service = (IEmployeeService) handler.getProxy();//返回的是一个代理对象
		//System.out.println(service.getClass());//class com.sun.proxy.$Proxy10 
		service.save(new Employee());
	}
	
	@Test
	public void testUpdate() throws Exception {
		IEmployeeService service = (IEmployeeService) handler.getProxy();//返回的是一个代理对象
		service.update(new Employee());
	}
	
}
