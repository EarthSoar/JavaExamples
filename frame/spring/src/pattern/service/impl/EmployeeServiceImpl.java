package pattern.service.impl;

import pattern.damain.Employee;
import pattern.dao.IEmployeeDAO;
import pattern.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService{

	private IEmployeeDAO dao;
	@Override
	public void save(Employee emp) {
		dao.save(emp);
	}

	@Override
	public void update(Employee emp) {
		dao.update(emp);
	}

	public void setDao(IEmployeeDAO dao) {
		this.dao = dao;
	}
	
	
}
