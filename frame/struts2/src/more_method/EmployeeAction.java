package more_method;

import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		System.out.println("默认打开execute()");
		return super.execute();
	}
	public void save() {
		System.out.println("保存");
	}
	public void delete() {
		System.out.println("删除");
	}
	public void update() {
		System.out.println("更改");
	}
	public void list() {
		System.out.println("员工列表");
	}
}
