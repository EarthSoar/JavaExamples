package di.constructor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ConstrutorTest {
	
	@Autowired
	private Employee e;
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private CollectionBean collection;
	
	@Test
	public void test() throws Exception {
		System.out.println(e);
	}
	
	@Test
	public void test1() {
		System.out.println(service);
	}
	
	
	@Test
	public void test2() {
		System.out.println(collection);
	}
	
}
