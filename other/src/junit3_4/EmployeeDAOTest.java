package junit3_4;

import junit.framework.TestCase;

public class EmployeeDAOTest extends TestCase {
	public void testName() throws Exception {
		System.out.println("name");
	}
	public void testSave() throws Exception {
		System.out.println("�������");
		
	}
	public void setUp(){
		System.out.println("��ʼ������");
	}
	public void tearDown(){
		System.out.println("����������");
	}
}
