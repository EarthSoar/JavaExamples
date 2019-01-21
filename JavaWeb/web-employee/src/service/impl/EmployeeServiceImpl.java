package service.impl;

import java.util.List;

import dao.IEmployeeDAO;
import dao.impl.EmployeeDAOImpl;
import daomain.Employee;
import page.PageResult;
import query.QueryObject;
import service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {

	private IEmployeeDAO dao = new EmployeeDAOImpl();
	@Override
	public void save(Employee e) {
		dao.save(e);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public void update(Employee e) {
		dao.update(e);
	}

	@Override
	public Employee get(Long id) {
		return dao.get(id);
	}

	@Override
	public List<Employee> list() {
		return dao.list();
	}

	@Override
	public PageResult query(QueryObject qo) {
		return dao.query(qo);
	}

}
