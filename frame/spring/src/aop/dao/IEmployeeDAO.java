package aop.dao;

import aop.doamin.Employee;

public interface IEmployeeDAO {
	void save(Employee emp);

	void update(Employee emp);
}
