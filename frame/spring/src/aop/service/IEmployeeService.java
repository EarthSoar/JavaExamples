package aop.service;

import aop.doamin.Employee;

public interface IEmployeeService {
	void save(Employee emp);

	void update(Employee emp);
}
