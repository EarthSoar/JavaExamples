package service;

import java.util.List;

import daomain.Employee;
import page.PageResult;
import query.QueryObject;

public interface IEmployeeService {
	void save(Employee e);

	void delete(Long id);

	void update(Employee e);

	Employee get(Long id);

	List<Employee> list();
	
	PageResult query(QueryObject qo);
}
