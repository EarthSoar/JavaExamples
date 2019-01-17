package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckLoginInterceptor extends AbstractInterceptor{
	private static final long serialVersionUID = 1L;

	//得打拦截器中参数,  ActionNames 对于  <params name="actionNames">中的name属性 
	public void setActionNames(String actionNames) {
		System.out.println(actionNames);
	}
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("拦截器执行.........");
		Object user = invocation.getInvocationContext().getSession().get("USER_IN_SESSION");
		if(user == null) {
			return "login";//返回login逻辑视图名称 重定向到login.jsp中
		}
		return invocation.invoke();//放行操作
	}
}
