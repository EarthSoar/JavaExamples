package crm;

//处理部门的请求
public class DepartmentAction {

	/**
	 * @return 返回是逻辑视图的名称
	 */
	public String excute() {
		System.out.println("department执行");
		return "list";
	}
}
