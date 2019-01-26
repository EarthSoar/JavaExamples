package aop.dao.impl;

import org.springframework.stereotype.Repository;

import aop.dao.IEmployeeDAO;
import aop.doamin.Employee;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO{
	@Override
	public void save(Employee emp) {
		System.out.println("保存员工");
	}

	@Override
	public void update(Employee emp) {
		System.out.println("修改员工" + 1 / 0);
	}

}
