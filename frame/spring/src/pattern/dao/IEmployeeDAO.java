package pattern.dao;

import pattern.damain.Employee;

public interface IEmployeeDAO {
	void save(Employee emp);

	void update(Employee emp);
}
