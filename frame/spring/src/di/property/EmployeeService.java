package di.property;

public class EmployeeService {
	private EmployeeDAO dao;

	public EmployeeDAO getDao() {
		return dao;
	}

	public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}

	@Override
	public String toString() {
		return "EmployeeService [dao=" + dao + "]";
	}
	
}
