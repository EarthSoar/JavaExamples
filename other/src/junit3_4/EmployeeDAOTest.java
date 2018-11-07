package junit3_4;

import junit.framework.TestCase;

public class EmployeeDAOTest extends TestCase {
	public void testName() throws Exception {
		System.out.println("name");
	}
	public void testSave() throws Exception {
		System.out.println("保存操作");
		
	}
	public void setUp(){
		System.out.println("开始。。。");
	}
	public void tearDown(){
		System.out.println("结束。。。");
	}
}
