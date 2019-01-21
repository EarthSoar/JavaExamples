package test;

import java.util.List;

import org.junit.jupiter.api.Test;

import dao.IEmployeeDAO;
import dao.impl.EmployeeDAOImpl;
import daomain.Employee;
import page.PageResult;
import query.EmployeeQueryObject;

class EmployeeDAOTest {
	private IEmployeeDAO dao = new EmployeeDAOImpl();
	@Test
	public void testSave() {
		Employee e = dao.get(1L);
		e.setUsername(e.getUsername() + 1);
		dao.save(e);
	}

	@Test
	public void testDelete() {
		
	}
	@Test
	public void testPage() {
		EmployeeQueryObject qo = new EmployeeQueryObject();
		//qo.setKeyword("giao");
		PageResult rs = dao.query(qo);
		List<?> l = rs.getListData();
		System.out.println("总页数" + rs.getTotalPage());
		System.out.println("结果总数数" + rs.getTotalCount());
		System.out.println("当前页数" + rs.getCurrentPage());
		System.out.println("上一页" + rs.getPrevPage());
		System.out.println("下一页" + rs.getNextPage());
		for (Object e : l) {
			System.out.println(e);
		}
	}

	@Test
	public void testUpdate() {
		Employee e = dao.get(1L);
		dao.update(e);
	}

	@Test
	public void testGet() {
		Employee e = dao.get(2L);
		System.out.println(e);
	}

	@Test
	public void testList() {
		List<Employee> list = dao.list();
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
}
