package pattern;

import org.junit.Test;

import pattern.damain.Employee;
import pattern.service.impl.EmployeeServiceImpl;
import pattern.wapper.EmployeeServiceImplWapper;

public class App {
	@Test
	public void testSave() throws Exception {
		EmployeeServiceImplWapper wapper = new EmployeeServiceImplWapper(
				new EmployeeServiceImpl(),//被包装的本身对象
				new TransactionManager()//事务管理器对象
				);
		wapper.save(new Employee());
	}
	@Test
	public void testUpdate() throws Exception {
		EmployeeServiceImplWapper wapper = new EmployeeServiceImplWapper(
				new EmployeeServiceImpl(),//被包装的本身对象
				new TransactionManager()//事务管理器对象
				);
		wapper.update(new Employee());
	}
	
	
}
