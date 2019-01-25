package pattern.dao.impl;

import pattern.damain.Employee;
import pattern.dao.IEmployeeDAO;

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
