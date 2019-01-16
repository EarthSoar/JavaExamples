package crm;

import core.ActionContext;

//处理employee请求
public class EmployeeAction {

	/**
	 * @return 返回是逻辑视图的名称
	 */
	public String excute() {
		System.out.println("employee执行");
		// 通过ActionContext获得到请求和响应对象
		String name = ActionContext.getContext().getRequest().getParameter("name");
		System.out.println(name);

		return "input";
	}
}
