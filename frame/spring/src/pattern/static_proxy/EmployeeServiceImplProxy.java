package pattern.static_proxy;

import pattern.TransactionManager;
import pattern.damain.Employee;
import pattern.service.IEmployeeService;

public class EmployeeServiceImplProxy implements IEmployeeService{
	
	private IEmployeeService target;//真实的对象
	private TransactionManager tx;
	
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

	public void setTarget(IEmployeeService target) {
		this.target = target;
	}

	public void setTx(TransactionManager tx) {
		this.tx = tx;
	}

}
