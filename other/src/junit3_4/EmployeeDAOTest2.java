package junit3_4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *	Junit4测速环境
 */
public class EmployeeDAOTest2 {
	@Test
	public void testSave() throws Exception {
		System.out.println("保存");
	}
	@Before
	public void testBefore() throws Exception {
		System.out.println("开始执行");
	}
	
	@After
	public void testAfter() throws Exception {
		System.out.println("最后执行");
	}
}
