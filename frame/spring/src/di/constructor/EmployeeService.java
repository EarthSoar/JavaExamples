package di.constructor;

public class EmployeeService {
	private EmployeeDAO dao;


	public EmployeeService(EmployeeDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public String toString() {
		return "EmployeeService [dao=" + dao + "]";
	}

}
