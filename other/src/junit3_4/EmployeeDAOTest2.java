package junit3_4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *	Junit4���ٻ���
 */
public class EmployeeDAOTest2 {
	@Test
	public void testSave() throws Exception {
		System.out.println("����");
	}
	@Before
	public void testBefore() throws Exception {
		System.out.println("��ʼִ��");
	}
	
	@After
	public void testAfter() throws Exception {
		System.out.println("���ִ��");
	}
}
