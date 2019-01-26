package aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import aop.doamin.Employee;
import aop.service.IEmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AopTest {

	@Autowired
	private IEmployeeService service;

	@Test
	public void testSave() throws Exception {
		service.save(new Employee());
	}

	@Test
	public void testUpdate() throws Exception {
		service.update(new Employee());
	}
}
