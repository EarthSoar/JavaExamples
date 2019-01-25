package pattern.wapper;

import pattern.TransactionManager;
import pattern.damain.Employee;
import pattern.service.IEmployeeService;

public class EmployeeServiceImplWapper implements IEmployeeService {

	private IEmployeeService target;// 包含真实的类型
	private TransactionManager tx;

	public EmployeeServiceImplWapper(IEmployeeService target, TransactionManager tx) {
		this.target = target;
		this.tx = tx;
	}

	@Override
	public void save(Employee emp) {
		tx.begin();
		try {
			target.save(emp);
			tx.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			tx.rollback();
		}
	}

	@Override
	public void update(Employee emp) {
		tx.begin();
		try {
			target.update(emp);
			tx.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			tx.rollback();
		}
	}
}
