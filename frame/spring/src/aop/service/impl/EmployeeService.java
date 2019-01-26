package aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aop.dao.IEmployeeDAO;
import aop.doamin.Employee;
import aop.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	private IEmployeeDAO dao;

	@Override
	public void save(Employee emp) {
		dao.save(emp);
	}

	public void setDao(IEmployeeDAO dao) {
		this.dao = dao;
	}

	@Override
	public void update(Employee emp) {
		dao.update(emp);
	}
}
